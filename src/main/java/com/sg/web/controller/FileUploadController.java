package com.sg.web.controller;

import com.sg.web.util.ConstValue;
import com.sg.web.util.QiniuUtil;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by sg on 2016/7/26.
 */
@Controller
@RequestMapping(value="fileupload")
public class FileUploadController {

    @RequestMapping(value="/upload")
    public String upload(HttpServletRequest request, HttpServletResponse response)throws IllegalStateException, IOException {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){

                    String myFileName = file.getOriginalFilename();
                    if(myFileName.trim() !=""){
                        CommonsMultipartFile cf= (CommonsMultipartFile)file;
                        DiskFileItem fi = (DiskFileItem)cf.getFileItem();
                        File f = fi.getStoreLocation();
                        //重命名上传后的文件名
                        String fileName = "demoUpload" + file.getOriginalFilename();
//                        //定义上传路径
//                        String path = "F:/" + fileName;
//                        File localFile = new File(path);
//                        file.transferTo(localFile);
                        QiniuUtil.SimpleUpload(fileName, ConstValue.QIUNIU_BUCKETNAME.SPRING_MVC_DEMO,f);
                    }
                }
            }

        }
        return "test";
    }
}
