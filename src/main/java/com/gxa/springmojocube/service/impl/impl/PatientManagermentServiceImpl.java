package com.gxa.springmojocube.service.impl.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gxa.springmojocube.entity.Patient;
import com.gxa.springmojocube.mapper.PatientManagermentMapper;
import com.gxa.springmojocube.service.impl.PatientManagermentService;
import com.gxa.springmojocube.utils.Result;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 患者管理实现类
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/23 13:26
 */
@Service
public class PatientManagermentServiceImpl extends ServiceImpl<PatientManagermentMapper,Patient> implements
    PatientManagermentService {
  @Autowired(required = false)
  private PatientManagermentMapper mapper;


  @Override
  public List<Patient> queryAll() {
    List<Patient> list=this.mapper.queryAll();
    return list;
  }

  @Override
  public void deleteById(Patient Patient) {
    this.mapper.deleteById(Patient);
  }

  @Override
  public void add(Patient reservation) {
    this.mapper.add(reservation);
  }

  @Override
  public Result selectById(Patient reservation) {
    if(reservation.getIndex()==""||reservation.getIndex()==null){
      reservation.setIndex("1");
    }
    if(reservation.getSize()==""||reservation.getSize()==null){
      reservation.setSize("10");
    }
    Integer pageNumber= Integer.valueOf(reservation.getIndex());
    Integer pageSize= Integer.valueOf(reservation.getSize());
    Page<Patient> page =
        query()
            .eq(StringUtils.isNotBlank(reservation.getId()), "id", reservation.getId())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_name()),
                "user_name",
                reservation.getUser_name())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_sex()),
                "user_sex",
                reservation.getUser_sex())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_age()),
                "user_age",
                reservation.getUser_age())
            .eq(StringUtils.isNotBlank(reservation.getPhone()), "phone", reservation.getPhone())
            .eq(StringUtils.isNotBlank(reservation.getIdentity()), "identity", reservation.getIdentity())
            .eq(StringUtils.isNotBlank(reservation.getId_card()), "id_card", reservation.getId_card())
            .eq(StringUtils.isNotBlank(reservation.getProvince()), "province", reservation.getProvince())
            .eq(StringUtils.isNotBlank(reservation.getAdress()), "adress", reservation.getAdress())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_appoint()),
                "user_appoint",
                reservation.getUser_appoint())
            .eq(
                StringUtils.isNotBlank(reservation.getCreate_time()),
                "create_time",
                reservation.getCreate_time())
            .eq(
                StringUtils.isNotBlank(reservation.getDay()),
                "day",
                reservation.getDay())
            .eq(
                StringUtils.isNotBlank(reservation.getStatus()),
                "day",
                reservation.getDay())
            .page(new Page<>(pageNumber, pageSize));

    List<Patient> list = page.getRecords();
    Long size1 =
    query()
        .eq(StringUtils.isNotBlank(reservation.getId()), "id", reservation.getId())
        .eq(
            StringUtils.isNotBlank(reservation.getUser_name()),
            "user_name",
            reservation.getUser_name())
        .eq(
            StringUtils.isNotBlank(reservation.getUser_sex()),
            "user_sex",
            reservation.getUser_sex())
        .eq(
            StringUtils.isNotBlank(reservation.getUser_age()),
            "user_age",
            reservation.getUser_age())
        .eq(StringUtils.isNotBlank(reservation.getPhone()), "phone", reservation.getPhone())
        .eq(StringUtils.isNotBlank(reservation.getIdentity()), "identity", reservation.getIdentity())
        .eq(StringUtils.isNotBlank(reservation.getId_card()), "id_card", reservation.getId_card())
        .eq(StringUtils.isNotBlank(reservation.getProvince()), "province", reservation.getProvince())
        .eq(StringUtils.isNotBlank(reservation.getAdress()), "adress", reservation.getAdress())
        .eq(
            StringUtils.isNotBlank(reservation.getUser_appoint()),
            "user_appoint",
            reservation.getUser_appoint())
        .eq(
            StringUtils.isNotBlank(reservation.getCreate_time()),
            "create_time",
            reservation.getCreate_time())
        .eq(
            StringUtils.isNotBlank(reservation.getDay()),
            "day",
            reservation.getDay())
        .eq(
            StringUtils.isNotBlank(reservation.getStatus()),
            "day",
            reservation.getDay())
        .count();
    return new Result().ok(list, size1.toString());
  }

  @Override
  public boolean updateById(Patient reservation) {
    this.mapper.updateById(reservation);
    return true;
  }

//  @Override
//  public List<Patient> search(Patient Patient) {
//    return this.mapper.search(Patient);
//  }
}
