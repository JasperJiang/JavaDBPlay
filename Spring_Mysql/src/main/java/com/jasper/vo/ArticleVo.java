package com.jasper.vo;

import com.jasper.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * Created by jjiang153 on 2017/5/4.
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ArticleVo {

    private String title;

    private String context;

    private String createdDate;

    private String lastModifiedDate;


    public ArticleVo() {
    }

    public static ArticleVo from(ArticleEntity articleEntity){
        return ArticleVo.builder()
                .title(articleEntity.getTitle())
                .context(articleEntity.getContext())
                .createdDate(articleEntity.getCreatedDate().toString())
                .lastModifiedDate(articleEntity.getLastModifiedDate().toString())
                .build();
    }

}
