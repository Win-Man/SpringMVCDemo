package com.sg.model;

import javax.persistence.*;

/**
 * Created by sg on 2016/8/1.
 */
@Entity
@Table(name="douban_movie")
public class DoubanMovie {

    @Id
    @Column(name="id",nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(name="tag")
    private String tag;

    @Basic
    @Column(name="douban_id")
    private Long doubanId;

    @Basic
    @Column(name="url")
    private String url;

    @Basic
    @Column(name="rate")
    private Double rate;

    @Basic
    @Column(name="title")
    private String title;

    @Basic
    @Column(name="is_new")
    private Boolean isNew;

    @Basic
    @Column(name="playable")
    private Boolean playable;

    @Basic
    @Column(name="cover_img_url")
    private String coverImgUrl;

    @Basic
    @Column(name="is_beetle_subject")
    private Boolean isBeetleSubject;

    @Basic
    @Column(name="cover_x")
    private Long coverX;

    @Basic
    @Column(name="cover_y")
    private Long coverY;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getDoubanId() {
        return doubanId;
    }

    public void setDoubanId(Long doubanId) {
        this.doubanId = doubanId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getPlayable() {
        return playable;
    }

    public void setPlayable(Boolean playable) {
        this.playable = playable;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public Boolean getBeetleSubject() {
        return isBeetleSubject;
    }

    public void setBeetleSubject(Boolean beetleSubject) {
        isBeetleSubject = beetleSubject;
    }

    public Long getCoverX() {
        return coverX;
    }

    public void setCoverX(Long coverX) {
        this.coverX = coverX;
    }

    public Long getCoverY() {
        return coverY;
    }

    public void setCoverY(Long coverY) {
        this.coverY = coverY;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
