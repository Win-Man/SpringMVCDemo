package com.sg.web.util;

import org.springframework.data.domain.Sort;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by sg on 2016/7/21.
 */
public class StringUtils {

    public static Sort.Direction getSortType(String sortType){
        if(sortType.equalsIgnoreCase("desc")){
            return Sort.Direction.DESC;
        }else if(sortType.equalsIgnoreCase("asc")){
            return Sort.Direction.ASC;
        }
        return Sort.Direction.DESC;
    }

    public static String getMD5(String str){
        String res = new String();
        try{
            //选择加密算法，还有其他选择项
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(str.getBytes());
            res = byteToString(bytes);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return res;
    }

    /*
     * 将返回的结果byte【】数组转换为16进制字符串
     * */
    public static String byteToString(byte[] bytes){
        String res = "";
        String hex = "0123456789abcdef";
        for(int i = 0;i < bytes.length;i++){
            //byte是8位，首先高四位右移4位与15（0000 1111）与一下就是高四位的值
            res += hex.charAt(bytes[i]>>4 & 15);
            res += hex.charAt(bytes[i] & 15);
        }
        return res;
    }
}
