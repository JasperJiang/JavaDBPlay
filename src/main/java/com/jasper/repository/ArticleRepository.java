package com.jasper.repository;

import com.jasper.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jjiang153 on 2017/5/4.
 */
public interface ArticleRepository extends CrudRepository<ArticleEntity,Long> {
}
