package com.blog.mapper.article;

import java.util.Date;

public class ArticleBaseinfo {
    private Integer articleBaseinfoId;

    private String articleTitle;

    private String articleSummary;

    private Integer userId;

    private Byte isTop;

    private Integer traffic;

    private Date createdDate;

    private Date updatedDate;

    private Byte isValid;

    public ArticleBaseinfo(){}

    public ArticleBaseinfo(String articleTitle, String articleSummary, Integer userId) {
        this.articleTitle = articleTitle;
        this.articleSummary = articleSummary;
        this.userId = userId;
        this.isValid = 1;
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }

    public Integer getArticleBaseinfoId() {
        return articleBaseinfoId;
    }

    public void setArticleBaseinfoId(Integer articleBaseinfoId) {
        this.articleBaseinfoId = articleBaseinfoId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary == null ? null : articleSummary.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getIsTop() {
        return isTop;
    }

    public void setIsTop(Byte isTop) {
        this.isTop = isTop;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
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
}