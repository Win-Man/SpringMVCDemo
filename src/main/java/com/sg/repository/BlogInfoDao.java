package com.sg.repository;

import com.sg.model.BlogInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by sg on 2016/7/19.
 */
public interface BlogInfoDao extends JpaSpecificationExecutor<BlogInfoEntity>,JpaRepository<BlogInfoEntity,Long> {
}
