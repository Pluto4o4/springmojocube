package com.gxa.springmojocube.entity.Qo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JiaFengYi
 * @date 2023/02/23/20:33
 * @description
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQo {
    private String cur;
    private String size;
}
