package com.sg.service;

import com.sg.model.JianshuAuthor;
import com.sg.repository.JianshuAuthorDao;
import com.sg.web.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016/8/2.
 */
@Component
@Transactional
public class JianshuAuthorService {

    @Autowired
    private JianshuAuthorDao jianshuAuthorDao;

    public JianshuAuthor getJianshuAuthorById(Long id){
        return this.jianshuAuthorDao.findOne(id);
    }

    public void saveJianshuAuthor(JianshuAuthor jianshuAuthor){
        this.jianshuAuthorDao.save(jianshuAuthor);
    }

    public void deleteJianshuAuthor(JianshuAuthor jianshuAuthor){
        this.jianshuAuthorDao.delete(jianshuAuthor);
    }
    public List<JianshuAuthor> getAllJianshuAuthor(){
        return this.jianshuAuthorDao.findAll();
    }

    public Page<JianshuAuthor> getPageJianshuAuthorByParams(int pageNumber, int pageSize, String sortName, String sortType, Map<String, String> params) {

        List<SearchFilter> filters = new ArrayList<SearchFilter>();
        if (params.get("name") != null) {
            filters.add(new SearchFilter("name", SearchFilter.Operator.LIKE, params.get("name")));
        }


        Specification<JianshuAuthor> spec = DynamicSpecifications.bySearchFilter(filters,
                JianshuAuthor.class);
        // 分页排序处理
        Sort sort = new Sort(StringUtils.getSortType(sortType), sortName);
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, sort);
        return this.jianshuAuthorDao.findAll(spec, pageRequest);
    }
}
