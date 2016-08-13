package com.sg.web.controller;

import com.sg.model.ArticleEntity;
import com.sg.model.DoubanMovie;
import com.sg.model.TestEntity;
import com.sg.service.ArticleService;
import com.sg.service.DoubanMovieService;
import com.sg.web.util.ControllerUtil;
import com.sg.web.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sg on 2016/7/19.
 */
@Controller
@RequestMapping(value = "/")
public class BlogController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private DoubanMovieService doubanMovieService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ServletResponse response) {
        List<ArticleEntity> articles = this.articleService.getAllArticle();
        request.setAttribute("articles",articles);
        return "index";
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String article(@RequestParam(value="id") Long id,
            ServletRequest request, ServletResponse response) {
        ArticleEntity articleEntity = this.articleService.getArticleById(id);
        request.setAttribute("article",articleEntity);
        return "blog/article";
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(ServletRequest request,ServletResponse response){
        return "login";
    }

    @RequestMapping(value="test",method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test");
        TestEntity test = new TestEntity();
        test.setName("sg");
        test.setRemark("123");
        List<TestEntity> users = new ArrayList<TestEntity>();
        users.add(test);
        mv.addObject("users",users);

        DoubanMovie doubanMovie = this.doubanMovieService.getDoubanMovieById(new Long(1));
        List<DoubanMovie> doubanMovies = this.doubanMovieService.getAllDoubanMovies();
        return mv;
    }


    @RequestMapping(value="login.json",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> loginConfirm(@RequestParam(value = "account")String account,
                                               @RequestParam(value = "password")String password,
            ServletRequest request,ServletResponse response){
        HashMap<String,Object> result = new HashMap<String, Object>();
        String message = "";
        boolean flag = true;
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(account, StringUtils.getMD5(password));
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                //使用shiro来验证
                token.setRememberMe(true);
                currentUser.login(token);//验证角色和权限
            }
        }catch(DisabledAccountException dae){
            flag = false;
            message = "禁用的账号";
        }catch (UnknownAccountException uae){
            flag = false;
            message = "错误的账号";
        }catch (ExcessiveAttemptsException eae){
            flag = false;
            message = "尝试次数过多";
        }catch (IncorrectCredentialsException ice){
            flag = false;
            message = "错误的凭证";
        }catch (ExpiredCredentialsException ece){
            flag = false;
            message = "过期的凭证";
        }catch (AuthorizationException ae){
            flag = false;
            message = "有错误";
        }catch (Exception e){
            flag = false;
            message = e.getMessage();
        }
        result = ControllerUtil.createReturnObject(flag,message,"");
        return result;
    }

    /**
     * 退出登录
     */
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(ServletRequest request,ServletResponse response) {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "login";
    }
}
