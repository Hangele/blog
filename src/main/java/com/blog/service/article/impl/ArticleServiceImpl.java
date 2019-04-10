package com.blog.service.article.impl;

import com.alibaba.fastjson.JSON;
import com.blog.mapper.article.*;
import com.blog.service.article.IArticleService;
import com.blog.utils.ResponseCode;
import com.blog.utils.ServerResponse;
import com.blog.vo.ArticleRequestVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: com.blog.service.article.impl
 * @Date: 2018/10/17 21:57
 * @Author: Hangele
 * @Description:
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleBaseinfoMapper articleBaseinfoMapper;

    @Autowired
    private ArticleTextMapper articleTextMapper;

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Autowired
    private ArticleWithTypeMapper articleWithTypeMapperr;

    @Override
    public ServerResponse<List> getArticleList(ArticleRequestVO request) {
        logger.info("获取文章列表：{}",JSON.toJSON(request));
        Map paramMap = new HashMap();
        if (StringUtils.isNotBlank(request.getSearchKey())){
            paramMap.put("searchKey",request.getSearchKey());
        }
        List<Map> lists = articleBaseinfoMapper.getArticleList(paramMap);
        if (lists == null && lists.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.DataNotExit.getCode(),
                    ResponseCode.DataNotExit.getDesc());
        }
        return ServerResponse.createBySuccess(lists);
    }

    @Override
    public ServerResponse<Map> getArticleInfo(ArticleRequestVO request) {
        return null;
    }

    @Override
    public ServerResponse<Map> addOrUpdateArticle(ArticleRequestVO request) {
        if (StringUtils.isBlank(request.getOperationType())
                || "add".equals(request.getOperationType())){
            //保存基本信息
            ArticleBaseinfo baseinfo = new ArticleBaseinfo(request.getArticleTitle(), request.getArticleSummary(), null);
            int count = articleBaseinfoMapper.insertSelective(baseinfo);
            if (count <= 0){
                return ServerResponse.createByErrorMessage(ResponseCode.OperationFail.getDesc());
            }
            //保存文章内容
            ArticleText text = new ArticleText(baseinfo.getArticleBaseinfoId(), null, request.getContent());
            count = articleTextMapper.insert(text);
            if (count <= 0){
                return ServerResponse.createByErrorMessage(ResponseCode.OperationFail.getDesc());
            }
        }else if ("update".equals(request.getOperationType())){
            // TODO
        }
        return null;
    }

    @Override
    public ServerResponse<Map> deleteArticle(ArticleRequestVO request) {
        // TODO
        return null;
    }

    @Override
    public ServerResponse<Map> getArticleTypeList(ArticleRequestVO request) {
        // TODO
        return null;
    }

    @Override
    public ServerResponse<Map> deleteArticleType(ArticleRequestVO request) {
        // TODO
        return null;
    }

    @Override
    public ServerResponse<Map> addOrUpdateArticleType(ArticleRequestVO request) {
        // TODO
        return null;
    }

    @Override
    public ServerResponse<Map> changeArticleType(ArticleRequestVO request) {
        // TODO
        return null;
    }
}
