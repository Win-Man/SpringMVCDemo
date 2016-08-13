package com.sg.service;

import com.sg.model.BlogInfoEntity;
import com.sg.repository.BlogInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sg on 2016/7/19.
 */
@Component
@Transactional
public class BlogInfoService {
    @Autowired
    private BlogInfoDao blogInfoDao;

    public void saveBlogInfo(BlogInfoEntity blogInfo){
        this.blogInfoDao.save(blogInfo);
    }
    public void deleteBlogInfo(BlogInfoEntity blogInfo){
        this.blogInfoDao.delete(blogInfo);
    }
    public BlogInfoEntity getBlogInfoById(Long id){
        return this.blogInfoDao.findOne(id);
    }
    public List<BlogInfoEntity> getAllBlogInfo(){
        return this.blogInfoDao.findAll();
    }

}
