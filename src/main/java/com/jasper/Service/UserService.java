package com.jasper.Service;

import com.jasper.entity.ArticleEntity;
import com.jasper.entity.UserEntity;
import com.jasper.repository.ArticleRepository;
import com.jasper.repository.UserRepository;
import com.jasper.vo.ArticleVo;
import com.jasper.vo.AuthReqVo;
import com.jasper.vo.RespVo;
import com.jasper.vo.UserVo;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jjiang153 on 2017/5/5.
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ArticleRepository articleRepository;

    public List showAllUsers(){
        Iterable<UserEntity> user = userRepository.findAll();

        List<UserVo> users = new ArrayList<UserVo>();

        for (UserEntity userEntity: user) {
            users.add(UserVo.from(userEntity));
        }

        return users;
    }


    public Object addUser(UserVo userVo){
        UserEntity userEntity = UserEntity.builder()
                .age(userVo.getAge())
                .country(userVo.getCountry())
                .firstName(userVo.getFirstName())
                .lastName(userVo.getLastName())
                .username(userVo.getUsername())
                .password(Base64.encodeBase64(userVo.getPassword().getBytes()))
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

        Map<String, Object> map = new HashMap<>();

        map.put("username",userVo.getUsername());
        return map;
    }

    public Object auth(AuthReqVo authReqVo){

        UserEntity userEntity = userRepository.findFirstByUsernameAndPassword(authReqVo.getUsername(),Base64.encodeBase64(authReqVo.getPassword().getBytes()));
        RespVo respVo;
        if (userEntity!=null){
            respVo = new RespVo(200,"good");
        }else {
            respVo = new RespVo(401,"no");
        }
        return respVo;
    }
}
