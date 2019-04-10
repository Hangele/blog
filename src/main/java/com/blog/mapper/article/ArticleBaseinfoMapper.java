package com.blog.mapper.article;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticleBaseinfoMapper {
    int deleteByPrimaryKey(Integer articleBaseinfoId);

    int insert(ArticleBaseinfo record);

    int insertSelective(ArticleBaseinfo record);

    ArticleBaseinfo selectByPrimaryKey(Integer articleBaseinfoId);

    int updateByPrimaryKeySelective(ArticleBaseinfo record);

    int updateByPrimaryKey(ArticleBaseinfo record);

    /**
     * 获取文章列表
     * @param paramMap
     * @return
     */
    List<Map> getArticleList(Map paramMap);
}