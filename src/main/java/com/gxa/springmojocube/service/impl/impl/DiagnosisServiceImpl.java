package com.gxa.springmojocube.service.impl.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxa.springmojocube.entity.Diagnosis;
import com.gxa.springmojocube.entity.Qo.DiagnosisListQo;
import com.gxa.springmojocube.entity.Qo.DiagnosisQo;
import com.gxa.springmojocube.entity.Qo.PageQo;
import com.gxa.springmojocube.mapper.DiagnosisMapper;
import com.gxa.springmojocube.service.impl.DiagnosisService;
import com.gxa.springmojocube.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Result<List<Diagnosis>> diagnosisList(DiagnosisListQo qo) {
        List<Diagnosis> res = null;
        try {
            Page<Diagnosis> page = new Page<>();
            page.setCurrent(Long.valueOf(qo.getCur()));
            page.setSize(Long.valueOf(qo.getSize()));
            QueryWrapper<Diagnosis> qw = new QueryWrapper<>();

            if(!StringUtils.isNotBlank(qo.getName())){
                qw.eq("name",qo.getName());
            }
            if(!StringUtils.isNotBlank(qo.getStatus())){
                qw.eq("status",qo.getStatus());
            }
            Page<Diagnosis> pages = diagnosisMapper.selectPage(page,qw);
            res = pages.getRecords();
            log.info("结果为:{}",res);
        }catch (Exception e){
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


}
