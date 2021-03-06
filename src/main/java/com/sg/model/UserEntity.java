package com.sg.model;

import javax.persistence.*;

/**
 * Created by sg on 2016/7/16.
// */
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{
    @Basic
    @Column(name="account")
    private String account;

    @Basic
    @Column(name="password")
    private String password;

    @ManyToOne
    @JoinColumn(name="role_id",nullable = true)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
