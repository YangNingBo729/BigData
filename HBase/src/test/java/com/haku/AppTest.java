package com.haku;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AppTest {
    private Connection conn = null;
    private Admin admin = null;

    @Before
    public void init() throws IOException {
        Configuration configuration = HBaseConfiguration.create();
        // 因为HBase的服务信息是注册在ZK上的 需要通过ZK获取HBase服务信息 从而建立连接
        configuration.set("hbase.zookeeper.quorum", "192.168.148.152");
        conn = ConnectionFactory.createConnection(configuration);
        admin = conn.getAdmin();


    }

    @Test
    public void test1() throws IOException {
        NamespaceDescriptor descriptor = NamespaceDescriptor.create("zpark").addConfiguration("author", "yangnb").build();
        admin.createNamespace(descriptor);

    }

    @After
    public void doAfter() throws IOException {
        if (admin != null) admin.close();
        if (conn != null) conn.close();
    }
}
