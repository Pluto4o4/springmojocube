package com.gxa.springmojocube.service.impl;

import com.gxa.springmojocube.entity.Diagnosis;
import com.gxa.springmojocube.entity.Qo.DiagnosisListQo;
import com.gxa.springmojocube.entity.Qo.DiagnosisQo;
import com.gxa.springmojocube.entity.Qo.PageQo;
import com.gxa.springmojocube.utils.Result;

import java.util.List;

/**
 * @author JiaFengYi
 * @date 2023/02/23/20:20
 **/
public interface DiagnosisService {
    Result<List<Diagnosis>> diagnosisList(String cur,String size,String name,String status);
    Result delect(String id);
    Result add(DiagnosisQo diagnosisQo);

    Result update(DiagnosisQo diagnosisQo);

    Result diagnosisInfo();

}
