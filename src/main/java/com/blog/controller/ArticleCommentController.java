package com.blog.controller;

import com.blog.utils.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @package: com.blog.controller
 * @Date: 2018/10/17 21:28
 * @Author: Hangele
 * @Description:
 */
@RestController
@RequestMapping(value = "/article_comment")
public class ArticleCommentController {

    Logger logger = LoggerFactory.getLogger(ArticleCommentController.class);

    @RequestMapping(value = "get_article_comment",method = RequestMethod.GET)
    public ServerResponse<List> getArticleComment(){
        logger.info("获取文章评论列表....................");
        return null;
    }

    @RequestMapping(value = "add_article_comment",method = RequestMethod.GET)
    public ServerResponse<List> addArticleComment(){
        logger.info("新增文章评论/子评论....................");
        return null;
    }

    @RequestMapping(value = "delete_article_comment",method = RequestMethod.GET)
    public ServerResponse<List> deleteArticleComment(){
        logger.info("删除文章评论....................");
        return null;
    }
}
