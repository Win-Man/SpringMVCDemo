package com.sg.model;

import javax.persistence.*;

/**
 * Created by sg on 2016/8/2.
 */
@Entity
@Table(name="jianshu_people")
public class JianshuAuthor {
    @Id
    @Column(name="id",nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    @Column(name="jianshu_id")
    private String jianshuId;

    @Basic
    @Column(name="avatar_url")
    private String avatarUrl;

    @Basic
    @Column(name="name")
    private String name;

    @Basic
    @Column(name="subscriptions")
    private Long subscriptions;

    @Basic
    @Column(name="followers")
    private Long followers;

    @Basic
    @Column(name="posts")
    private Long posts;

    @Basic
    @Column(name="words")
    private Long words;

    @Basic
    @Column(name="gain_love")
    private Long gainLove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJianshuId() {
        return jianshuId;
    }

    public void setJianshuId(String jianshuId) {
        this.jianshuId = jianshuId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Long subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public Long getPosts() {
        return posts;
    }

    public void setPosts(Long posts) {
        this.posts = posts;
    }

    public Long getWords() {
        return words;
    }

    public void setWords(Long words) {
        this.words = words;
    }

    public Long getGainLove() {
        return gainLove;
    }

    public void setGainLove(Long gainLove) {
        this.gainLove = gainLove;
    }
}
