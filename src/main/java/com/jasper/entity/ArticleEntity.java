package com.jasper.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by jjiang153 on 2017/5/4.
 */

@Entity
@Table(name = "articles")
@Builder
@Getter
@Setter
@AllArgsConstructor
public class ArticleEntity {

    @Id
    @Column(name = "aid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long aid;

    @Column(name = "title",nullable = false,length = 25)
    private String title;

    @Column(name = "context",nullable = false,length = 255)
    private String context;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "user_id") // 多表的外键字段名
    private UserEntity author;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("context", context)
                .toString();
    }

    public ArticleEntity() {
    }
}
