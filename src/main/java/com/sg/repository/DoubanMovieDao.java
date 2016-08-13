package com.sg.repository;

import com.sg.model.DoubanMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by sg on 2016/8/1.
 */
public interface DoubanMovieDao extends JpaSpecificationExecutor<DoubanMovie>,JpaRepository<DoubanMovie,Long>{
}
