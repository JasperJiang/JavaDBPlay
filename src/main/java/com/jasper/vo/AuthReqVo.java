package com.jasper.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 * Created by jjiang153 on 2017/5/8.
 */
@Getter
@AllArgsConstructor
public class AuthReqVo implements Serializable {

    private String username;
    private byte[] password;


    public AuthReqVo(Authentication auth) {
        this.username = auth.getName().trim();
        this.password = auth.getCredentials().toString().getBytes();
    }
}