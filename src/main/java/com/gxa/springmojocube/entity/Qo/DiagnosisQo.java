package com.gxa.springmojocube.entity.Qo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JiaFengYi
 * @date 2023/02/23/20:32
 * @description
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiagnosisQo extends PageQo {

    private String id;
    private String title;
    private String type;
    private String userName;
    private String department;
    private String bedNumber;
    private String pic;
    private String price;
    private String createTime;
    private String drug;
    private String payStatus;
    private String status;
    private String province;
    private String address;

}
