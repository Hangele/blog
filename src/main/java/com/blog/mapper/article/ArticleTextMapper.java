package com.blog.mapper.article;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTextMapper {
    int deleteByPrimaryKey(Integer articleTextId);

    int insert(ArticleText record);

    int insertSelective(ArticleText record);

    ArticleText selectByPrimaryKey(Integer articleTextId);

    int updateByPrimaryKeySelective(ArticleText record);

    int updateByPrimaryKeyWithBLOBs(ArticleText record);

    int updateByPrimaryKey(ArticleText record);
}