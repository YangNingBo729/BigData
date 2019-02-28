package com.haku;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    StorageClient client = null;

    @Before
    public void before() throws Exception {

        // 加载配置文件
        ClientGlobal.init("fdfs_client.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        // 通过client对象操作分布式文件系统
        client = new StorageClient(trackerServer, null);

    }

    @Test
    public void testUpload() throws Exception {
        client.upload_file("E:\\weatherwebservice.xml", "xml", new NameValuePair[]{new
                NameValuePair("author", "Yang")});


    }


    /*
     * 文件下载
     * */


    @Test
    public void testDownload() throws Exception {

        byte[] group1s = client.download_file("group1", "M00/00/00/wKiUilx0MOKALdyXAAB6tiPkjUw367.xml");

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\weatherwebserviceHAHA.xml");

        fileOutputStream.write(group1s);
        fileOutputStream.close();

    }


    /*
     *
     * 删除文件
     * */
    @Test
    public void testDelete() throws IOException, MyException {
        client.delete_file("group1", "M00/00/00/wKiUilx0MOKALdyXAAB6tiPkjUw367.xml");
    }


    /*
     * 获 取文件信息
     * */


    @Test
    public void testGetFileInfo() throws IOException, MyException {

        FileInfo file_info = client.get_file_info("group1", "M00/00/00/wKiUilx0MOKALdyXAAB6tiPkjUw367.xml");

        System.out.println("文件大小：" + file_info.getFileSize());
        System.out.println("创建时间：" + file_info.getCreateTimestamp());
        System.out.println("来源IP地址：" + file_info.getSourceIpAddr());

    }


    /*
     * 获取文件的元数据
     *
     * */
    @Test
    public void testMetadata() throws IOException, MyException {
        NameValuePair[] nameValuePairs = client.get_metadata("group1", "M00/00/00/wKiUilx0MdiAaebuAAB6tiPkjUw306.xml");
        for (NameValuePair nameValuePair : nameValuePairs) {

            System.out.println(nameValuePair.getValue());

        }


    }


}
