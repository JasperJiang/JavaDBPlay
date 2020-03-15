package com.jasper.exception;

import com.jasper.enums.ErrorCodesEnum;

/**
 * Created by jjiang153 on 2017/5/8.
 */
public class TestExcepition extends RuntimeException {

    private final ErrorCodesEnum errorCode;
    private final String msg;

    public TestExcepition(ErrorCodesEnum errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
        this.msg = msg;
    }
}
