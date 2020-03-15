package com.jasper.vo;

import com.jasper.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.crypto.codec.Base64;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by jjiang153 on 2017/5/4.
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserVo {

    @Email
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String country;

    private int age;

    private Set<ArticleVo> articles;

    private String createdDate;

    private String lastModifiedDate;


    public UserVo() {
        //Default ctor
    }

    public static UserVo from(UserEntity userEntity){
        Set<ArticleVo> articleVos = userEntity.getArticles()
                .stream()
                .map(articleEntity -> ArticleVo.from(articleEntity)) //对没一向操作
                .collect(Collectors.toSet());

        return UserVo.builder()
                .age(userEntity.getAge())
                .firstName(userEntity.getFirstName())
                .country(userEntity.getCountry())
                .lastName(userEntity.getLastName())
                .username(userEntity.getUsername())
                .articles(articleVos)
                .createdDate(userEntity.getCreatedDate().toString())
                .lastModifiedDate(userEntity.getLastModifiedDate().toString())
                .password(Base64.decode(userEntity.getPassword()).toString())
                .build();
    }
}
