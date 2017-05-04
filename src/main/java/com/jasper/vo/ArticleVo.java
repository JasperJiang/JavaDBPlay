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

    private long aid;

    private String title;

    private String context;

    public ArticleVo() {
    }

    public static ArticleVo from(ArticleEntity articleEntity){
        return ArticleVo.builder()
                .title(articleEntity.getTitle())
                .aid(articleEntity.getAid())
                .context(articleEntity.getContext())
                .build();
    }

}
