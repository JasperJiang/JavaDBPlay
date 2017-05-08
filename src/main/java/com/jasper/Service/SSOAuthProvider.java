package com.jasper.Service;

import com.jasper.entity.UserEntity;
import com.jasper.exception.SSOAuthenticationException;
import com.jasper.repository.UserRepository;
import com.jasper.vo.AuthReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by jjiang153 on 2017/5/8.
 */
@Service("SSOAuthProvider")
public class SSOAuthProvider implements AuthenticationProvider {

    @Autowired
    UserRepository userRepository;


    @Override
    public Authentication authenticate(Authentication auth) {
        AuthReqVo authReqVo = new AuthReqVo(auth);
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("read"));

        String username = authReqVo.getUsername();
        byte[] password = Base64.encode(authReqVo.getPassword());

        System.out.println("auth = [" + username + password + "]");

        UserEntity userEntity= userRepository.findFirstByUsernameAndPassword(username,password);

        if (userEntity != null) {
            return new UsernamePasswordAuthenticationToken(auth, auth.getCredentials(), authorities);
        }else {
            throw new SSOAuthenticationException("no auth");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}

