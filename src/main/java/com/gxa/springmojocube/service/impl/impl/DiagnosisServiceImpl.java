package com.gxa.springmojocube.service.impl.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxa.springmojocube.entity.Diagnosis;
import com.gxa.springmojocube.entity.Drug;
import com.gxa.springmojocube.entity.Dto.DiagnosisTableDto;
import com.gxa.springmojocube.entity.Qo.DiagnosisListQo;
import com.gxa.springmojocube.entity.Qo.DiagnosisQo;
import com.gxa.springmojocube.entity.Qo.PageQo;
import com.gxa.springmojocube.mapper.DiagnosisMapper;
import com.gxa.springmojocube.mapper.DrugMapper;
import com.gxa.springmojocube.service.impl.DiagnosisService;
import com.gxa.springmojocube.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author JiaFengYi
 * @date 2023/02/23/20:20
 * @description
 **/

@Service
@Slf4j
public class DiagnosisServiceImpl implements DiagnosisService {
    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public Result<List<Diagnosis>> diagnosisList(String cur,String size,String name,String status) {
        List<Diagnosis> res = null;
        try {
            Page<Diagnosis> page = new Page<>();
            page.setCurrent(Long.valueOf(cur));
            page.setSize(Long.valueOf(size));
            QueryWrapper<Diagnosis> qw = new QueryWrapper<>();
            if(StringUtils.isNotBlank(name)){
                qw.eq("user_name",name);
            }
            if(StringUtils.isNotBlank(status)){
                qw.eq("status",status);
            }
            Page<Diagnosis> pages = diagnosisMapper.selectPage(page,qw);
            res = pages.getRecords();
            log.info("结果为:{}",res);
        }catch (Exception e){
            System.out.println(e);
            return new Result().error();

        }
        return new Result().ok(res);
    }

    @Override
    public Result delect(String id) {
        int count = 0;
        try {
            count = diagnosisMapper.deleteById(id);
        }catch (Exception e){
            return new Result().error("删除的id不能为空");

        }
        return count == 1 ? new Result().ok() : new Result().error();
    }

    @Override
    public Result add(DiagnosisQo diagnosisQo) {
        Diagnosis diagnosis = null;
        try {
            diagnosis = new Diagnosis();
            //复制属性
            BeanUtils.copyProperties(diagnosisQo,diagnosis);
            diagnosisMapper.insert(diagnosis);
        }catch (Exception e){
            log.info("异常为:{}",e);
            return new Result().error();
        }
        return new Result().ok();
    }

    @Override
    public Result update(DiagnosisQo diagnosisQo) {
        Diagnosis diagnosis = null;
        try {
            diagnosis = new Diagnosis();
            //复制属性
            BeanUtils.copyProperties(diagnosisQo,diagnosis);
            diagnosisMapper.updateById(diagnosis);
        }catch (Exception e){
            return new Result().error();
        }
        return new Result().ok();
    }

    @Override
    public Result diagnosisInfo() {
        //诊断总数
        QueryWrapper<Diagnosis> qw = new QueryWrapper<>();
        qw.select("id");
        Long count = diagnosisMapper.selectCount(qw);
        log.info("诊断总数{}",count);
        //应收金额
        String num1 =  diagnosisMapper.GetamountReceivable();
        log.info("应收金额{}",num1);
        //实收金额
        String num2 = diagnosisMapper.GetAmountReceived();
        log.info("应收金额{}",num2);
        //取消总数
        String num3 = diagnosisMapper.GetCancelCount();
        log.info("应收金额{}",num3);
        //药品总数
        QueryWrapper<Drug> drugQw = new QueryWrapper<>();
        drugQw.select("drug_name");
        List<Drug> drugs = drugMapper.selectList(drugQw);
        List<String> drugsName = new ArrayList<>();
        drugs.stream().forEach(drug -> {
            drugsName.add(drug.getDrugName());
        });
        DiagnosisTableDto diagnosisTableDto = new DiagnosisTableDto();
        diagnosisTableDto.setTotel(String.valueOf(count));
        diagnosisTableDto.setCancelCount(num3);
        diagnosisTableDto.setAmountReceived(num2);
        diagnosisTableDto.setAmountReceivable(num1);
        diagnosisTableDto.setDrugs(drugsName);
        return new Result().ok(diagnosisTableDto);
    }


}
