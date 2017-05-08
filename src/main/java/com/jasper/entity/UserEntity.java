package com.jasper.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jjiang153 on 2017/5/4.
 */

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserEntity extends AbstractEntity {
    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    @Column(name = "username", nullable = false,length = 30,unique = true)
    private String username;


    @Column(name = "password",nullable = false,length = 30)
    @Lob
    private byte[] password;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "country", nullable = false, length = 255)
    private String country;

    @Column(name = "age", nullable = false, length = 3)
    private int age;

    @Column(name = "enabled",nullable = false)
    private boolean enabled = true;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<ArticleEntity> articles;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("first_name", firstName)
                .append("last_name",lastName)
                .append("country",country)
                .append("articles",articles)
                .toString();
    }

    public UserEntity() {
    }
}
