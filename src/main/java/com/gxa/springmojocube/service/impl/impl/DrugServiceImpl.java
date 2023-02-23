package com.gxa.springmojocube.service.impl.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gxa.springmojocube.entity.Drug;
import com.gxa.springmojocube.mapper.DrugMapper;
import com.gxa.springmojocube.service.impl.DrugService;
import com.gxa.springmojocube.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
@Service
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements DrugService {
   private static Result result=new Result<>();
   @Override
   public Result addDrug(Drug drug) {
      result=new Result();
      if(save(drug))return result.ok();
      return result.error();
   }

   //分页查询
   public Result selectPage(Integer index,Integer size,String supplierName,String status){
      result=new Result();
      Page<Drug> page=query()
            .eq(StringUtils.isNotBlank(supplierName),"supplier_name",supplierName)
            .eq(StringUtils.isNotBlank(status),"status",status)
            .page(new Page<>(index,size));

      List<Drug> list = page.getRecords();

      Long size1 = query()
            .eq(StringUtils.isNotBlank(supplierName), "supplier_name", supplierName)
            .eq(StringUtils.isNotBlank(status), "status", status)
            .count();


      return result.ok(list,size1.toString());
   }
   @Resource
   DrugMapper drugMapper;
   public Result deleteDrug(String id){
      result=new Result();
      Drug drug = query().eq("id", id).one();
      if(Objects.isNull(drug))return result.error();
      int i = drugMapper.deleteById(drug);
      if(i>0)return result.ok();
      return result.error();
   }

   public Result updateDrug(Drug drug){
      result=new Result();
      boolean yes = updateById(drug);
      if(yes)return result.ok();
      return result.error();
   }
}
