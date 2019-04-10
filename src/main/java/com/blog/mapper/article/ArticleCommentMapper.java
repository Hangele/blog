package com.blog.mapper.article;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCommentMapper {
    int deleteByPrimaryKey(Integer articleCommentId);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    ArticleComment selectByPrimaryKey(Integer articleCommentId);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);
}