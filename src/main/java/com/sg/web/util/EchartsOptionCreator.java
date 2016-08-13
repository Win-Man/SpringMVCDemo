package com.sg.web.util;

import com.sg.model.JianshuAuthor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sg on 2016/8/3.
 */
public class EchartsOptionCreator {

    public static HashMap<String,Object> getJianshuAuthorRadarOption(JianshuAuthor author,String title){
        HashMap<String,Object> result = new HashMap<String, Object>();
        if(author == null){
            return result;
        }
        result.put("title",author.getName()+"信息雷达图");

        List<String> legend_data = new ArrayList<String>();
        legend_data.add(author.getName());

        result.put("legend_data",legend_data);

        List<HashMap>series_data = new ArrayList<HashMap>();
        HashMap<String,Object>authorMap = new HashMap<String, Object>();
        List<Long> value = new ArrayList<Long>();
        value.add(author.getSubscriptions());
        value.add(author.getFollowers());
        value.add(author.getPosts());
        value.add(author.getWords());
        value.add(author.getGainLove());
        authorMap.put("value",value);
        authorMap.put("name",author.getName());
        series_data.add(authorMap);

        result.put("series_data",series_data);
        return result;
    }
}
