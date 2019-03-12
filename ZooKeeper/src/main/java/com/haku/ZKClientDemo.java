package com.haku;

import org.I0Itec.zkclient.ZkClient;

public class ZKClientDemo {
    public static void main(String[] args) {
        ZkClient client = new ZkClient("192.168.148.151:2181");
        //client.createPersistent("/yangnb/supernb","nb");
//        List<String> children = client.getChildren("/yangnb");
//        for (String s : children) {
//            System.out.println(s);
//        }
//        Object data = client.readData("/yangnb/supernb");
//        System.out.println(data);

//        client.writeData("/yangnb","超级牛逼");
        client.delete("/yangnb/supernb");
        client.delete("/yangnb");
        client.close();

    }
}
