package com.haku;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.io.IOException;

public class ZKWatch {
    public static void main(String[] args) throws IOException {
        ZkClient client = new ZkClient("192.168.148.151:2181");
        client.subscribeDataChanges("/yangnb", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("修改值为：" + o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(s + "被删除了");
            }
        });
        System.in.read();
    }
}
