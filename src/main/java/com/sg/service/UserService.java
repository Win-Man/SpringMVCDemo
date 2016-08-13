package com.sg.service;

import com.sg.model.UserEntity;
import com.sg.repository.UserDao;
import com.sg.web.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016/7/19.
 */
@Component
@Transactional
public class UserService {

    @Resource
    private UserDao userDao;

    public void saveUser(UserEntity user){
        this.userDao.save(user);
    }
    public void deleteUser(UserEntity user){
        this.userDao.delete(user);
    }
    public UserEntity getUserById(Long id){
        return this.userDao.findOne(id);
    }
    public List<UserEntity> getAllUser(){
        return this.userDao.findAll();
    }

    public UserEntity getUserByAccount(String account){
        return this.userDao.getUserByAccount(account);
    }

    public Page<UserEntity> getPageUserByParams(int pageNumber, int pageSize, String sortName, String sortType, Map<String, String> params) {

        List<SearchFilter> filters = new ArrayList<SearchFilter>();
        if (params.get("account") != null) {
            filters.add(new SearchFilter("account", SearchFilter.Operator.LIKE, params.get("account")));
        }

        filters.add(new SearchFilter("state", SearchFilter.Operator.EQ,1));

        Specification<UserEntity> spec = DynamicSpecifications.bySearchFilter(filters,
                UserEntity.class);
        // 分页排序处理
        Sort sort = new Sort(StringUtils.getSortType(sortType), sortName);
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, sort);
        return this.userDao.findAll(spec, pageRequest);
    }
}
