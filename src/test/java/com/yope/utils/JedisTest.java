package com.yope.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by yope on 2016/8/28.
 */

public class JedisTest {
    /**
     * 简单测试redis服务器的连通性和可用性
     * @param args
     */
    public static void main(String[] args) {
        JedisPool pool = new JedisPool("192.168.1.160", 6380);
        Jedis jedis = pool.getResource();
        //清空数据
        jedis.flushAll();
        //操作String
        jedis.set("name", "yope");
        System.out.println(jedis.get("name"));
        //操作list
        jedis.lpush("nosql", "hbase");
        jedis.lpush("nosql", "redis");
        jedis.lpush("nosql", "mongodb");
        jedis.lpush("nosql", "couchdb");
        jedis.lpush("nosql", "neo4j");
        System.out.println(jedis.lrange("nosql", 0, -1));
    }
}
