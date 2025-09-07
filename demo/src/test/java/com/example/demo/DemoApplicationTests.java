package com.example.demo;


import com.example.demo.pojo.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

//    @Autowired
//    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("name","一只游鱼");
        //获取
        Object object = stringRedisTemplate.opsForValue().get("name");
        System.out.println(object);

    }

   private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testObject() throws JsonProcessingException {
        //创建
        User user = new User("一只游鱼", 21);
        //手动序列化
        String json = objectMapper.writeValueAsString(user);
        //写入数据
        stringRedisTemplate.opsForValue().set("user:1",json);
        //获取数据
        String userJson = stringRedisTemplate.opsForValue().get("user:1");

        //反序列化
        User user1 = objectMapper.readValue(userJson, User.class);
        System.out.println(user1);

    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:2","name","一只游鱼");
        stringRedisTemplate.opsForHash().put("user:2","age","21");
        //获取
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:2");
        System.out.println(entries);
    }

}
