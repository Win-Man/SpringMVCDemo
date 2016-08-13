package com.sg.web.util;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.sg.model.TestEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sg on 2016/7/20.
 */
public class TestUtil {
    public static void toJsonTest(){
        TestEntity test = new TestEntity();
        test.setId(Long.valueOf("1"));
        test.setName("123");
        test.setRemark("456");
        String objJson = JsonUtils.toJson(test);
        System.out.println(objJson);
    }

    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = ConstValue.QINIU.ACCESS_KEY;
    String SECRET_KEY = ConstValue.QINIU.SECRET_KEY;
    //要上传的空间
    String bucketname = "springmvc";
    //上传到七牛后保存的文件名
    String key = "my-java.jpg";
    //上传文件的路径
    String FilePath = "F:/1.jpg";

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    UploadManager uploadManager = new UploadManager();

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }



    /**
     * @param
     *            :请求接口
     * @param httpArg
     *            :参数
     * @return 返回结果
     */
    public static String weatherAPIrequest(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey",  ConstValue.BAIDU_API.APIKEY);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String args[]) throws IOException{
        String httpUrl = "http://apis.baidu.com/tianyiweather/basicforecast/weatherapi";
        String httpArg = "area=101010100";
        String jsonResult = weatherAPIrequest(httpUrl, httpArg);
        System.out.println(jsonResult);
    }
}