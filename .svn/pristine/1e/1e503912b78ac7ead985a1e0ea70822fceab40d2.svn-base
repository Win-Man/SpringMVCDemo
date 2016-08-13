package com.sg.web.util;

import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by sg on 2016/7/20.
 */
public class ControllerUtil {

    public ControllerUtil(){}

    public static void print(PrintWriter printWriter,String str){
        try{
            printWriter.write(str);
            printWriter.flush();
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void print(PrintWriter printWriter, Object obj){
        String jsonStr = JsonUtils.toJson(obj);
        print(printWriter,jsonStr);
    }

    public static void printGrid(PrintWriter printWriter,Long count,Object obj){
        StringBuffer sb = new StringBuffer();
        sb.append("{\"totalCount\":");
        sb.append(count);
        sb.append(",\"items\":");
        sb.append(JsonUtils.toJson(obj));
        sb.append("}");
        print(printWriter,sb.toString());
    }

    public static HashMap<String,Object> createReturnObject(boolean isSuccess,String message,Object content){
        HashMap<String,Object> result = new HashMap<String, Object>();
        if(isSuccess){
            result.put("CODE",1);
        }else{
            result.put("CODE",0);
        }
        result.put("MESSAGE",message);
        result.put("CONTENT",content);
        return result;
    }

}
