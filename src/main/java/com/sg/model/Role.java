package com.sg.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sg on 2016/7/28.
 */
@Entity
@Table(name = "role")
public class Role extends BaseEntity {


    @Basic
    @Column(name = "role_name", nullable = true)
    private String roleName;




    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
