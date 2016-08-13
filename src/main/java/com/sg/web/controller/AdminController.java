package com.sg.web.controller;

import com.sg.model.*;
import com.sg.service.*;
import com.sg.web.util.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016/7/26.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private BlogInfoService blogInfoService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private JianshuAuthorService jianshuAuthorService;

    @RequestMapping(method = RequestMethod.GET)
    public String admin(ServletRequest request, ServletResponse response) {
        Subject curretnUser = SecurityUtils.getSubject();
        String account = (String)curretnUser.getPrincipal();
        UserEntity user = this.userService.getUserByAccount(account);
        request.setAttribute("user",user);
        return "admin";
    }

    @RequestMapping(value="/jianshu" ,method = RequestMethod.GET)
    public String jianshu(ServletRequest request,ServletResponse response){
        return "radom/jianshu";
    }

    @RequestMapping(value="/jianshu/author/view")
    public String jianshuAuthorView(ServletRequest request,ServletResponse response){
        return "radom/jianshuAuthorView";
    }

    @RequestMapping(value="/jianshu/author/List",method = RequestMethod.GET)
    public void jianshuAuthorList(
            @RequestParam(value="name",defaultValue = "")String name,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            @RequestParam(value = "limit", defaultValue = "10") int pageSize,
            @RequestParam(value = "sortName", defaultValue = "id") String sortName,
            @RequestParam(value = "sortType", defaultValue = "desc") String sortType,ServletRequest request,ServletResponse response,PrintWriter printWriter){
        Map<String,String> params = new HashMap<String, String>();
        params.put("name",name);
        Page<JianshuAuthor> authors = this.jianshuAuthorService.getPageJianshuAuthorByParams(pageNumber,pageSize,sortName,sortType,params);

        ControllerUtil.printGrid(printWriter,authors.getTotalElements(),authors.getContent());
    }


    @RequestMapping(value="/jianshu/author/radar.json")
    @ResponseBody
    public HashMap<String,Object> radarJSON(
            @RequestParam(value="id",defaultValue = "0")Long id, ServletRequest request,ServletResponse response){
        JianshuAuthor author = this.jianshuAuthorService.getJianshuAuthorById(id);
        return EchartsOptionCreator.getJianshuAuthorRadarOption(author,"雷达图");
    }

    @RequestMapping(value = "/postArticle", method = RequestMethod.GET)
    public String postArticle(@RequestParam(value = "id", defaultValue = "0") Long id, ServletRequest request, ServletResponse response) {
        ArticleEntity articleEntity = null;
        if (id != null) {
            if (this.articleService.getArticleById(id) != null) {
                articleEntity = this.articleService.getArticleById(id);
            }
        }
        if (articleEntity == null) {
            articleEntity = new ArticleEntity();
        }
        request.setAttribute("article", articleEntity);
        return "blog/postArticle";
    }

    @RequestMapping(value = "/articleSave", method = RequestMethod.POST)
    public String saveArticle(ServletRequest request, ServletResponse response, ArticleEntity article, PrintWriter printWriter) {
        this.articleService.saveArticle(article);
        return "blog/managerArticle";
    }

    @RequestMapping(value = "/managerArticle", method = RequestMethod.GET)
    public String managerArticle(ServletRequest request, ServletResponse response) {
        return "blog/managerArticle";
    }

    @RequestMapping(value = "/fileupload", method = RequestMethod.GET)
    public String fileupload(ServletRequest request, ServletResponse response) {
        return "radom/fileupload";
    }

    @RequestMapping(value = "/articleList", method = RequestMethod.GET)
    @ResponseBody
    public void articleList(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                            @RequestParam(value = "limit", defaultValue = "10") int pageSize,
                            @RequestParam(value = "sortName", defaultValue = "id") String sortName,
                            @RequestParam(value = "sortType", defaultValue = "desc") String sortType, ServletRequest request, ServletResponse response, PrintWriter printWriter) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Map<String, String> params = new HashMap<String, String>();
        params.put("title", "");
        Page<ArticleEntity> pageArticles = this.articleService.getPageArticleByParams(pageNumber, pageSize, sortName, sortType, params);


        List<ArticleEntity> articles = this.articleService.getAllArticle();
        Long count = this.articleService.getAllArticleCount();
        ControllerUtil.printGrid(printWriter, pageArticles.getTotalElements(), pageArticles.getContent());
//        result.put("totalCount",pageArticles.getTotalElements());
//        result.put("items",pageArticles.getContent());
//        return result;
    }

    @RequestMapping(value = "/articleDelete")
    @ResponseBody
    public HashMap<String, Object> articleDelete(@RequestParam(value = "id") Long id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        if (id != null) {
            this.articleService.deleteArticleById(id);
        }
        result = ControllerUtil.createReturnObject(true, "删除成功", null);
        return result;
    }

    @RequestMapping(value = "/blogInfoManage")
    public String blogInfoManage(ServletRequest request, ServletResponse response) {
        return "blog/blogInfoManage";
    }

    @RequestMapping(value = "/blogInfoSave", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> blogInfoSave(BlogInfoEntity blogInfo, ServletRequest servletRequest, ServletResponse servletResponse) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        if (blogInfo != null) {
            this.blogInfoService.saveBlogInfo(blogInfo);
        }
        result = ControllerUtil.createReturnObject(true, "添加成功", "");
        return result;
    }

    @RequestMapping(value = "/qiniu", method = RequestMethod.GET)
    public String qiniu(ServletRequest request, ServletResponse response) {
        return "radom/qiniu";
    }

    @RequestMapping(value = "/roleManage", method = RequestMethod.GET)
    public String roleManage(ServletRequest request, ServletResponse response) {
        return "admin/roleManage";
    }

    @RequestMapping(value = "/roleList", method = RequestMethod.GET)
    public void roleList(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                         @RequestParam(value = "limit", defaultValue = "10") int pageSize,
                         @RequestParam(value = "sortName", defaultValue = "id") String sortName,
                         @RequestParam(value = "sortType", defaultValue = "desc") String sortType, ServletRequest request, ServletResponse response, PrintWriter printWriter) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Map<String, String> params = new HashMap<String, String>();
        String roleName = request.getParameter("roleName");
        if (roleName != null) {
            params.put("roleName", roleName);
        }
        Page<Role> roles = this.roleService.getPageRoleByParams(pageNumber, pageSize, sortName, sortType, params);
        ControllerUtil.printGrid(printWriter, roles.getTotalElements(), roles.getContent());

    }

    @RequestMapping(value = "/allRole", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> allRole(ServletRequest request, ServletResponse response) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Role> roles = this.roleService.getAllRoles();
        result.put("size", roles.size());
        result.put("items", roles);
        return result;
    }


    @RequestMapping(value = "/roleDelete")
    @ResponseBody
    public HashMap<String, Object> roleDelete(@RequestParam(value = "id", defaultValue = "0") Long id, ServletRequest request, ServletResponse response) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        if (id != null) {
            Role role = this.roleService.getRoleById(id);
            if (role != null) {
                this.roleService.deleteRole(role);
                result = ControllerUtil.createReturnObject(true, "删除成功", null);
            } else {
                result = ControllerUtil.createReturnObject(false, "该角色不存在", null);
            }
        } else {
            result = ControllerUtil.createReturnObject(false, "该角色id不存在", null);
        }
        return result;
    }

    @RequestMapping(value = "/roleEdit")
    public String roleEdit(@RequestParam(value = "roleId", defaultValue = "0") Long id, ServletRequest request, ServletResponse response) {
        Role role = null;
        if (id != null) {
            role = this.roleService.getRoleById(id);
        }
        if (role == null) {
            role = new Role();
        }
        request.setAttribute("role", role);
        return "admin/roleEdit";
    }

    @RequestMapping(value = "/roleSave", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> roleEdit(@RequestParam(value = "roleId", defaultValue = "0") Long id,
                                            @RequestParam(value = "roleName", defaultValue = "") String roleName, ServletRequest request, ServletResponse response) {

        HashMap<String, Object> result = new HashMap<String, Object>();
        roleName = roleName.trim();
        if ("".equals(roleName)) {
            result = ControllerUtil.createReturnObject(false, "角色名字不能为空", null);
            return result;
        }
        Role role = this.roleService.getRoleById(id);
        if (role != null) {
            role.setRoleName(roleName.trim());
            this.roleService.saveRole(role);
            result = ControllerUtil.createReturnObject(true, "保存成功", null);
        } else {
            role = new Role();
            role.setRoleName(roleName);
            this.roleService.saveRole(role);
            result = ControllerUtil.createReturnObject(true, "新增成功", null);
        }
        return result;
    }

    @RequestMapping(value = "/userManage", method = RequestMethod.GET)
    public String userManage(ServletRequest request, ServletResponse response) {
        return "admin/userManage";
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public void userList(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                         @RequestParam(value = "limit", defaultValue = "10") int pageSize,
                         @RequestParam(value = "sortName", defaultValue = "id") String sortName,
                         @RequestParam(value = "sortType", defaultValue = "desc") String sortType, ServletRequest request, ServletResponse response, PrintWriter printWriter) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Map<String, String> params = new HashMap<String, String>();
        String account = request.getParameter("account");
        if (account != null) {
            params.put("account", account);
        }
        Page<UserEntity> users = this.userService.getPageUserByParams(pageNumber, pageSize, sortName, sortType, params);
        ControllerUtil.printGrid(printWriter, users.getTotalElements(), users.getContent());
    }

    @RequestMapping(value = "/userEdit")
    public String userEdit(@RequestParam(value = "userId", defaultValue = "0") Long id, ServletRequest request, ServletResponse response) {
        UserEntity user = null;
        if (id != null) {
            user = this.userService.getUserById(id);
        }
        if (user == null) {
            user = new UserEntity();
        }
        request.setAttribute("user", user);
        return "admin/userEdit";
    }

    @RequestMapping(value = "/userDelete")
    @ResponseBody
    public HashMap<String, Object> userDelete(@RequestParam(value = "id", defaultValue = "0") Long id, ServletRequest request, ServletResponse response) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        if (id != null) {
            UserEntity user = this.userService.getUserById(id);
            if (user != null) {
                this.userService.deleteUser(user);
                result = ControllerUtil.createReturnObject(true, "删除成功", null);
            } else {
                result = ControllerUtil.createReturnObject(false, "该用户不存在", null);
            }
        } else {
            result = ControllerUtil.createReturnObject(false, "该用户ID不存在", null);
        }
        return result;
    }

    @RequestMapping(value = "/userSave", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> userSave(@RequestParam(value = "userId", defaultValue = "0") Long userId,
        @RequestParam(value = "roleId", defaultValue = "0") Long roleId,
        @RequestParam(value = "account", defaultValue = "") String account,
        @RequestParam(value = "password",defaultValue = "") String password,
        ServletRequest request, ServletResponse response) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        String message = "保存成功";
        UserEntity user = this.userService.getUserById(userId);
        if(user == null){
            user = new UserEntity();
            message = "新建成功";
        }
        Role role = this.roleService.getRoleById(roleId);
        user.setRole(role);
        user.setAccount(account);
        user.setPassword(StringUtils.getMD5(password));
        this.userService.saveUser(user);
        result = ControllerUtil.createReturnObject(true,message,null);
        return result;
    }

    @RequestMapping(value="weather",method = RequestMethod.GET)
    public String weather(ServletRequest request,ServletResponse response){
        return "radom/weather";
    }

    @RequestMapping(value="weather/query")
    @ResponseBody
    public Map<String,Object> weatherQuery(@RequestParam(value="areaId",defaultValue = "0")String areaId,ServletRequest request,ServletResponse response){
        Map<String,Object> result = new HashMap<String, Object>();
        String queryResult = TestUtil.weatherAPIrequest(ConstValue.BAIDU_API.WEATHER_URL,"area="+areaId);
        result = JsonUtils.toMap(queryResult);
        return result;
    }
}
