package com.sg.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by sg on 2016/7/19.
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name="id",nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    @Column(name="createDate",nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate = new Date();
    @Basic
    @Column(name="state",nullable=false)
    private int state = 1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }



    public int getState() {

        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
