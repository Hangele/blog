package com.blog.mapper.article;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTypeMapper {
    int deleteByPrimaryKey(Integer articleTypeId);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    ArticleType selectByPrimaryKey(Integer articleTypeId);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);
}