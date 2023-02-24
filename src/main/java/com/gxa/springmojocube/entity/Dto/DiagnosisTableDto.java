package com.gxa.springmojocube.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JiaFengYi
 * @date 2023/02/23/23:33
 * @description
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisTableDto {
    private String totel;
    private String amountReceivable;
    private String AmountReceived;
    private String cancelCount;
}
