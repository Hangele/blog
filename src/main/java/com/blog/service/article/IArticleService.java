package com.blog.service.article;

import com.blog.utils.ServerResponse;
import com.blog.vo.ArticleRequestVO;

import java.util.List;
import java.util.Map;

/**
 * @package: com.blog.service.article.impl
 * @Date: 2018/10/17 21:51
 * @Author: Hangele
 * @Description:
 */
public interface IArticleService {

    /**
     * 获取文章列表
     * @return
     */
    ServerResponse<List> getArticleList(ArticleRequestVO request);

    /**
     * 获取文章详细信息
     * @return
     */
    ServerResponse<Map> getArticleInfo(ArticleRequestVO request);

    /**
     * 新增或修改文章
     * @return
     */
    ServerResponse<Map> addOrUpdateArticle(ArticleRequestVO request);

    /**
     * 删除文章
     * @return
     */
    ServerResponse<Map> deleteArticle(ArticleRequestVO request);

    /**
     * 获取文章详细信息
     * @return
     */
    ServerResponse<Map> getArticleTypeList(ArticleRequestVO request);

    /**
     * 获取文章分类列表
     * @return
     */
    ServerResponse<Map> deleteArticleType(ArticleRequestVO request);

    /**
     * 新增或修改文章分类
     * @return
     */
    ServerResponse<Map> addOrUpdateArticleType(ArticleRequestVO request);

    /**
     * 修改文章分类
     * @return
     */
    ServerResponse<Map> changeArticleType(ArticleRequestVO request);

}
