package com.sg.repository;

import com.sg.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by sg on 2016/7/28.
 */
public interface RoleDao extends JpaSpecificationExecutor<Role>,JpaRepository<Role,Long> {

    @Query("select role from Role role where role.state = 1")
    List<Role> getAllRoles();

}
