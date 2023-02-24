package com.gxa.springmojocube.service.impl.impl;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gxa.springmojocube.entity.Supplier;
import com.gxa.springmojocube.mapper.SupplierMapper;
import com.gxa.springmojocube.service.impl.SupplierService;
import com.gxa.springmojocube.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {
   @Resource
   private SupplierMapper supplierMapper;
   //增
   public Result addSupplier(Supplier supplier){
      int insert = supplierMapper.insert(supplier);
      if(insert>0)return new Result().ok();
      return new Result().error("服务器错误");
   }

   //删
   public Result deleteSupplier(String id){
      Supplier supplier = query().eq("id", id).one();
      if(removeById(supplier)){
         return new Result().ok();
      }
      return new Result().error();

   }
   //改
   public Result updateSupplier(Supplier supplier){
      if(updateById(supplier))return new Result().ok("修改成功");
      return new Result().error("修改失败");
   }
   //分页查询所有,或按条件查询
   public Result selectPage(Integer pageNumber, Integer pageSize,String supplierName,String type,String status) {
      Page<Supplier> page = query()
            .like(StringUtils.isNotBlank(supplierName), "supplier_name", supplierName)
            .eq(StringUtils.isNotBlank(type), "type", type)
            .eq(StringUtils.isNotBlank(status), "status", status)
            .page(new Page<>(pageNumber, pageSize));

      List<Supplier> list = page.getRecords();
      Long size = query()
            .eq(StringUtils.isNotBlank(supplierName), "supplier_name", supplierName)
            .eq(StringUtils.isNotBlank(type), "type", type)
            .eq(StringUtils.isNotBlank(status), "status", status)
            .count();


      return new Result().ok(list,size.toString());
   }

   //模糊查询供应商
   public Result selectSupplierName(String supplierName) {
      List<Supplier> list= query()
            .like(StringUtils.isNotBlank(supplierName), "supplier_name", supplierName)
            .list();

      Integer size=list.size();

      return new Result().ok(list,size.toString());
   }

}
