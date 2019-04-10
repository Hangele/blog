package com.blog.controller;

import com.alibaba.fastjson.JSON;
import com.blog.service.article.IArticleService;
import com.blog.utils.ServerResponse;
import com.blog.utils.ValidatedErrors;
import com.blog.vo.ArticleRequestVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @package: com.blog.controller
 * @Date: 2018/10/17 20:58
 * @Author: Hangele
 * @Description:   文章CRUD
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private IArticleService iArticleService;

    @RequestMapping(value = "get_article_list",method = RequestMethod.GET)
    public ServerResponse<List> getArticleList(ArticleRequestVO request){
        logger.info("获取文章列表....................");
        return iArticleService.getArticleList(request);
    }

    @RequestMapping(value = "get_article_info",method = RequestMethod.GET)
    public ServerResponse<List> getArticleInfo(
            @Validated({ArticleRequestVO.getArticleinfo.class})ArticleRequestVO request,
            BindingResult result){
        logger.info("获取文章详情....................");
        return null;
    }

    @RequestMapping(value = "add_update_article",method = RequestMethod.GET)
    public ServerResponse<Map> addOrUpdateArticle(
            @Validated({ArticleRequestVO.addUpdateArticle.class})ArticleRequestVO request,
            BindingResult result){
        if (result.hasErrors()){
            return ValidatedErrors.getErrors(result);
        }
        logger.info("新增或修改文章:{}",JSON.toJSON(request));
        return iArticleService.addOrUpdateArticle(request);
    }

    @RequestMapping(value = "delete_article",method = RequestMethod.GET)
    public ServerResponse<Map> deleteArticle(){
        // TODO
        logger.info("删除文章....................");
        return null;
    }

    @RequestMapping(value = "get_article_type_list",method = RequestMethod.GET)
    public ServerResponse<Map> getArticleTypeList(){
        // TODO
        logger.info("获取文章分类列表.........");
        return null;
    }

    @RequestMapping(value = "add_update_article_type",method = RequestMethod.GET)
    public ServerResponse<Map> addOrUpdateArticleType(){
        // TODO
        logger.info("新增或修改文章分类....................");
        return null;
    }

    @RequestMapping(value = "delete_article_type",method = RequestMethod.GET)
    public ServerResponse<Map> deleteArticleType(){
        // TODO
        logger.info("删除文章分类....................");
        return null;
    }

    @RequestMapping(value = "change_article_type",method = RequestMethod.GET)
    public ServerResponse<Map> changeArticleType(){
        // TODO
        logger.info("修改文章分类.................");
        return null;
    }

}
