package com.sg.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sg on 2016/7/19.
 */
@Entity
@Table(name="blogInfo")
public class BlogInfoEntity extends BaseEntity{
    /**
     *作者
     */
    @Basic
    @Column(name="authorName")
    private String authorName;
    /**
     *格言
     */
    @Basic
    @Column(name="motto")
    private String motto;
    /**
     *网页标题
     */
    @Basic
    @Column(name="title")
    private int title;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }
}
