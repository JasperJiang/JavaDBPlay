package com.jasper.controller;

import com.jasper.Service.UserService;
import com.jasper.enums.ErrorCodesEnum;
import com.jasper.exception.TestExcepition;
import com.jasper.vo.AuthVo;
import com.jasper.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Object auth(@Validated @RequestBody AuthVo authVo){
        return userService.auth(authVo);
    }


    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Object test(){
        throw new TestExcepition(ErrorCodesEnum.ERR_TEST,"testtest");
    }
}
