package com.it.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.it.pojo.User;
import com.it.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController     //直接返回字符串，不走视图解析器，不用再每一个都添加@ResponseBody
public class UserController {

    @RequestMapping("/json1")
//    @ResponseBody       //他就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson, ObjectMapper  创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User(1,"小豪",16);

        String str = mapper.writeValueAsString(user);
        System.out.println(str);

        return str;
    }

    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {

        User user1 = new User(1, "小豪1号", 16);
        User user2 = new User(2, "小豪2号", 17);
        User user3 = new User(3, "小豪3号", 18);
        User user4 = new User(4, "小豪4号", 19);

        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

//        return new ObjectMapper().writeValueAsString(list);
        return JsonUtils.getJson(list);
    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {

        Date date = new Date();
        //自定义时间日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //ObjectMapper时间解析后的默认格式为：Timestamp 时间戳
        return new ObjectMapper().writeValueAsString(sdf.format(date));
    }

    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {

        /*ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        Date date = new Date();

        //ObjectMapper时间解析后的默认格式为：Timestamp 时间戳
        return mapper.writeValueAsString(date);*/

        Date date = new Date();
        return JsonUtils.getJson(date);
    }

    @RequestMapping("/json5")
    public String json5() throws JsonProcessingException {

        User user1 = new User(1, "小豪1号", 16);
        User user2 = new User(2, "小豪2号", 17);
        User user3 = new User(3, "小豪3号", 18);
        User user4 = new User(4, "小豪4号", 19);

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(userList);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);
        return "hello";
    }
}
