package com.sg.web.util;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.File;

/**
 * Created by sg on 2016/7/27.
 */
public class QiniuUtil {
    private static final String ACCESS_KEY = ConstValue.QINIU.ACCESS_KEY;
    private static final String SECRET_KEY = ConstValue.QINIU.SECRET_KEY;

    public static Response SimpleUpload(String saveName, String bucketName, File file) {
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //创建上传对象
        UploadManager uploadManager = new UploadManager();
        //获得上传token
        String upToken = auth.uploadToken(bucketName);
        try {
            //调用put方法上传
            Response res = uploadManager.put(file, saveName, upToken);
            return res;
        } catch (QiniuException e) {
            Response r = e.response;
            return r;
        }
    }

    public static Response SimpleUpload(String saveName, String bucketName, String filePath) {
        return SimpleUpload(saveName, bucketName, new File(filePath));
    }


}
