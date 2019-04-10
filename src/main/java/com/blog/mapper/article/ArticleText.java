package com.blog.mapper.article;

import java.util.Date;

public class ArticleText {
    private Integer articleTextId;

    private Integer articleBaseinfoId;

    private Integer userId;

    private Date createdDate;

    private Date updatedDate;

    private Byte isValid;

    private String content;

    public ArticleText(){}

    public ArticleText(Integer articleBaseinfoId, Integer userId, String content) {
        this.articleBaseinfoId = articleBaseinfoId;
        this.userId = userId;
        this.content = content;
        this.isValid = 1;
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }

    public Integer getArticleTextId() {
        return articleTextId;
    }

    public void setArticleTextId(Integer articleTextId) {
        this.articleTextId = articleTextId;
    }

    public Integer getArticleBaseinfoId() {
        return articleBaseinfoId;
    }

    public void setArticleBaseinfoId(Integer articleBaseinfoId) {
        this.articleBaseinfoId = articleBaseinfoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}