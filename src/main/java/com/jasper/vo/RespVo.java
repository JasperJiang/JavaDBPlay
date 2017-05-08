package com.jasper.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jjiang153 on 2017/5/8.
 */
@Getter
@Setter
@AllArgsConstructor
public class RespVo {
    private int ErrorCode;
    private String message;
}
