package com.gxa.springmojocube.service.impl.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.gxa.springmojocube.entity.SupplierMore;

import com.gxa.springmojocube.mapper.SupplierMapper;
import com.gxa.springmojocube.mapper.SupplierMoreMapper;
import com.gxa.springmojocube.service.impl.SupplierMoreService;

import com.gxa.springmojocube.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupplierMoreServiceImpl extends ServiceImpl<SupplierMoreMapper, SupplierMore> implements SupplierMoreService {

   @Resource
   SupplierMoreMapper supplierMoreMapper;
   @Override
   public Result addSupplierMore(SupplierMore supplierMore) {
      try {
         supplierMoreMapper.insert(supplierMore);
      } catch (Exception e) {
         e.printStackTrace();
         return new Result().error("添加失败");
      }
      return new Result().ok("添加成功");
   }

   @Override
   public Result deleteSupplierMore(String id) {
      try {
         SupplierMore supplierMore = query().eq("id", id).one();
         supplierMoreMapper.deleteById(supplierMore);
      } catch (Exception e) {
         e.printStackTrace();
         return new Result().error("用户不存在");
      }
      return new Result().ok("删除成功");


   }

   @Override
   public Result getPage(Integer index, Integer size, String title, String phone, String contact, String status, String pic) {
      List<SupplierMore> list;
      try {
         list= (List<SupplierMore>) query()
               .like(StringUtils.isNotBlank(title),"title",title)
               .eq(StringUtils.isNotBlank(phone),"phone",phone)
               .eq(StringUtils.isNotBlank(contact),"contact",contact)
               .eq(StringUtils.isNotBlank(status),"status",status)
               .eq(StringUtils.isNotBlank(pic),"pic",pic)
               .page(new Page<>(index,size));
      } catch (Exception e) {
         e.printStackTrace();
         return new Result().error("查询失败");
      }
      return new Result().ok(list,((Integer)list.size()).toString());
   }

   @Override
   public Result updateSupplierMore(SupplierMore supplierMore) {
      try {
         supplierMoreMapper.updateById(supplierMore);
      } catch (Exception e) {
         e.printStackTrace();
         return new Result().error("修改失败");
      }
      return new Result().ok("修改成功");
   }
}
