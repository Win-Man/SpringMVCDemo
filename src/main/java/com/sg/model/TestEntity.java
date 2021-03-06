package com.sg.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sg on 2016/7/16.
 */
@Entity
@Table(name = "test", schema = "springdemo", catalog = "")
public class TestEntity extends BaseEntity{
    @Basic
    @Column(name="name",nullable = true)
    private String name;
    @Basic
    @Column(name="remark",nullable = true)
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
