package com.sg.service;

import com.sg.model.ArticleEntity;
import com.sg.repository.ArticleDao;
import com.sg.web.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016/7/19.
 */
@Component
@Transactional
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public void saveArticle(ArticleEntity article) {
        this.articleDao.save(article);
    }

    public void deleteArticle(ArticleEntity article) {
        this.articleDao.delete(article);
    }

    public void deleteArticleById(Long id) {
        this.articleDao.delete(id);
    }

    public ArticleEntity getArticleById(Long id) {
        return this.articleDao.findOne(id);
    }

    public List<ArticleEntity> getAllArticle() {
        return this.articleDao.findAll();
    }

    public Long getAllArticleCount() {
        return this.articleDao.count();
    }

    public Page<ArticleEntity> getPageArticle(int pageNumber, int pageSize, String sortName, String sortType) {
        Sort sort = new Sort(StringUtils.getSortType(sortType), sortName);
        Pageable pageable = new PageRequest(pageNumber - 1, pageSize, sort);
        return this.articleDao.findAll(pageable);
    }

    public Page<ArticleEntity> getPageArticleByParams(int pageNumber, int pageSize, String sortName, String sortType, Map<String, String> params) {

        List<SearchFilter> filters = new ArrayList<SearchFilter>();
        if (params.get("title") != null) {
            filters.add(new SearchFilter("title", Operator.LIKE, params.get("title")));
        }

        Specification<ArticleEntity> spec = DynamicSpecifications.bySearchFilter(filters,
                ArticleEntity.class);
        // 分页排序处理
        Sort sort = new Sort(StringUtils.getSortType(sortType), sortName);
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, sort);
        return this.articleDao.findAll(spec, pageRequest);
    }
}
