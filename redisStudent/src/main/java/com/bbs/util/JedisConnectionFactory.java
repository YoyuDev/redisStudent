package com.bbs.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {

    private static final JedisPool jedisPool;
    static {
        //配置Redis连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(8);//最大连接数
        jedisPoolConfig.setMaxIdle(8);//最大空闲连接数
        jedisPoolConfig.setMinIdle(0);//最小空闲连接数
        jedisPoolConfig.setMaxWaitMillis(1000);//最大等待时间
        //创建连接池对象
        jedisPool = new JedisPool(jedisPoolConfig, "192.168.81.131", 6379, 1000);

    }

    public static Jedis getJedisPool() {
        return jedisPool.getResource() ;
    }
}
