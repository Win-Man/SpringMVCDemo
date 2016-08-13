package com.sg.model;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

/**
 * Created by sg on 2016/7/19.
 */
@Entity
@Table(name="article")
public class ArticleEntity extends BaseEntity {
    /**
     * 文章标题
     */
    @Basic
    @Column(name="title",nullable = true)
    private String title;
    /**
     * 文章内容
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "TEXT",name = "content")
    private  String content;

    /**
     * 文章摘要
     */
    @Basic
    @Column(name="articleAbstract",nullable = true)
    private  String articleAbstract;

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
