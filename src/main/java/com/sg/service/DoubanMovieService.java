package com.sg.service;

import com.sg.model.DoubanMovie;
import com.sg.repository.DoubanMovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sg on 2016/8/1.
 */
@Component
@Transactional
public class DoubanMovieService  {
    @Autowired
    private DoubanMovieDao doubanMovieDao;

    public DoubanMovie getDoubanMovieById(Long id){
        return this.doubanMovieDao.findOne(id);
    }

    public void saveDoubanMovie(DoubanMovie doubanMovie){
        this.doubanMovieDao.save(doubanMovie);
    }

    public void deleteDoubanMovie(DoubanMovie doubanMovie){
        this.doubanMovieDao.delete(doubanMovie);
    }
    public List<DoubanMovie> getAllDoubanMovies(){
        return this.doubanMovieDao.findAll();
    }
}
