package com.sg.service;

import com.sg.model.Role;
import com.sg.repository.RoleDao;
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
 * Created by sg on 2016/7/28.
 */
@Component
@Transactional
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role getRoleById(Long id){
        return this.roleDao.findOne(id);
    }

    public void saveRole(Role role){
        this.roleDao.save(role);
    }

    public void deleteRole(Role role){
        this.roleDao.delete(role);
    }

    public List<Role> getAllRoles(){
        return this.roleDao.getAllRoles();
    }

    public Page<Role> getPageRoleByParams(int pageNumber, int pageSize, String sortName, String sortType, Map<String, String> params) {

        List<SearchFilter> filters = new ArrayList<SearchFilter>();
        if (params.get("roleName") != null) {
            filters.add(new SearchFilter("roleName", SearchFilter.Operator.LIKE, params.get("roleName")));
        }

        filters.add(new SearchFilter("state", SearchFilter.Operator.EQ,1));

        Specification<Role> spec = DynamicSpecifications.bySearchFilter(filters,
                Role.class);
        // 分页排序处理
        Sort sort = new Sort(StringUtils.getSortType(sortType), sortName);
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, sort);
        return this.roleDao.findAll(spec, pageRequest);
    }
}
