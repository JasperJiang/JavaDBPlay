package com.jasper.controller;

import com.jasper.entity.ArticleEntity;
import com.jasper.entity.UserEntity;
import com.jasper.repository.ArticleRepository;
import com.jasper.repository.UserRepository;
import com.jasper.vo.ArticleVo;
import com.jasper.vo.UserVo;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserRepository userRepository;
    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public List test(){

        Iterable<UserEntity> user = userRepository.findAll();

        List<UserVo> users = new ArrayList<UserVo>();

        for (UserEntity userEntity: user) {
            users.add(UserVo.from(userEntity));
        }

        return users;
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(@RequestBody UserVo userVo){

        UserEntity userEntity = UserEntity.builder()
                .age(userVo.getAge())
                .country(userVo.getCountry())
                .firstName(userVo.getFirstName())
                .lastName(userVo.getLastName())
                .username(userVo.getUsername())
                .build();

        userRepository.save(userEntity);

        for (ArticleVo articleVo: userVo.getArticles()) {
            ArticleEntity articleEntity = ArticleEntity.builder()
                    .title(articleVo.getTitle())
                    .context(articleVo.getContext())
                    .author(userEntity)
                    .build();
            articleRepository.save(articleEntity);
        }
        return "SUCCESS!!!!";
    }
}
