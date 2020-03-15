package com.jasper.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by jjiang153 on 2017/5/8.
 */
public class SSOAuthenticationException extends AuthenticationException {
    public SSOAuthenticationException(String msg) {
        super(msg);
    }
}
