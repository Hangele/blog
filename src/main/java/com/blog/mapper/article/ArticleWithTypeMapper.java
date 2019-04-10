package com.blog.mapper.article;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticleWithTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleWithType record);

    int insertSelective(ArticleWithType record);

    ArticleWithType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleWithType record);

    int updateByPrimaryKey(ArticleWithType record);
}