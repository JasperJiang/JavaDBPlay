package com.jasper.controller;

import com.jasper.Service.UserService;
import com.jasper.entity.ArticleEntity;
import com.jasper.entity.UserEntity;
import com.jasper.repository.ArticleRepository;
import com.jasper.repository.UserRepository;
import com.jasper.vo.ArticleVo;
import com.jasper.vo.AuthReqVo;
import com.jasper.vo.UserVo;
import jdk.nashorn.internal.runtime.options.Option;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by jjiang153 on 2017/5/4.
 */

@RestController
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "showusers",method = RequestMethod.GET)
    public List showUsers(){
        return userService.showAllUsers();
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Object addArticle(@Validated @RequestBody UserVo userVo){

        return userService.addUser(userVo);
    }

    @RequestMapping(value = "auth",method = RequestMethod.POST)
    public Object auth(@Validated @RequestBody AuthReqVo authReqVo){
        return userService.auth(authReqVo);
    }
}
