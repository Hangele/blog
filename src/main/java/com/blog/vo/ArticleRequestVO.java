package com.blog.vo;

import javax.validation.constraints.NotNull;

/**
 * @package: com.blog.vo
 * @Date: 2018/10/18 20:41
 * @Author: Hangele
 * @Description:  文章请求VO
 */
public class ArticleRequestVO extends PageBean{

    /**
     * 文章ID
     */
    @NotNull(groups = {getArticleinfo.class, deleteArticle.class},message = "文章Id不能不传~")
    private Integer articleId;
    /**
     * 文章分类ID
     */
    @NotNull(groups = {deleteArticleType.class, changeArticleType.class},message = "文章分类Id不能不传~")
    private Integer articleTypeId;
    /**
     * 文章ID
     */
    @NotNull(groups = {addUpdateArticle.class},message = "文章标题不能不传~")
    private String articleTitle;
    /**
     * 用户Id
     */
//    @NotNull(groups = {addUpdateArticle.class},message = "文章标题不能不传~")
    private Integer userId;
    /**
     * 文章简介
     */
    @NotNull(groups = {addUpdateArticle.class},message = "文章简介不能不传~")
    private String articleSummary;
    /**
     * 是否置顶文章
     */
//    @NotNull(groups = {addUpdateArticle.class},message = "文章简介不能不传~")
    private Integer isTop;
    /**
     * 文章内容
     */
    @NotNull(groups = {addUpdateArticle.class},message = "文章内容不能不传~")
    private String content;
    /**
     * 分类名
     */
    @NotNull(groups = {addUpdateArticleType.class},message = "文章分类不能不传~")
    private String typeName;
    /**
     * 搜索关键字
     */
    private String searchKey;

    /**
     * 操作
     */
    private String operationType;

    public interface getArticleinfo {}
    public interface addUpdateArticle {}
    public interface deleteArticle {}
    public interface addUpdateArticleType {}
    public interface deleteArticleType {}
    public interface changeArticleType {}

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
