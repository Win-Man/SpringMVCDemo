package com.sg.repository;

import com.sg.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by sg on 2016/7/19.
 */
public interface UserDao extends  JpaSpecificationExecutor<UserEntity>,JpaRepository<UserEntity,Long> {

    @Query("select user from UserEntity user where user.account = ?1 and user.state = 1")
    UserEntity getUserByAccount(String account);
}
