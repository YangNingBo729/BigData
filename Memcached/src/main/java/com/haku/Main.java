//package com.haku;
//
//import net.rubyeye.xmemcached.MemcachedClient;
//import net.rubyeye.xmemcached.MemcachedClientBuilder;
//import net.rubyeye.xmemcached.XMemcachedClientBuilder;
//import net.rubyeye.xmemcached.exception.MemcachedException;
//import net.rubyeye.xmemcached.utils.AddrUtil;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        // 多个Memcached Server：host1:port1
//        // host2:port2
//        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("192.168.148.142:11211"));
//        MemcachedClient memcachedClient = builder.build();
//        try {
//        // 存储数据 参数⼀一：key名 参数⼆二：expire时间（单位秒）表示永久存储（默认是⼀一个⽉月）
//        //参数三：value值
//            memcachedClient.set("hello", 0, "Hello,xmemcached");
//        // 获取数据
//            String value = memcachedClient.get("hello");
//            System.out.println("hello=" + value);
//        // 删除数据
//            memcachedClient.delete("hello");
//            value = memcachedClient.get("hello");
//            System.out.println("hello=" + value);
//        } catch (MemcachedException e) {
//            System.err.println("MemcachedClient operation fail");
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            System.err.println("MemcachedClient operation timeout");
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//        // ignore
//        }
//        try {
//        //close memcached client
//            memcachedClient.shutdown();
//        } catch (IOException e) {
//            System.err.println("Shutdown MemcachedClient fail");
//            e.printStackTrace();
//        }
//    }
//}