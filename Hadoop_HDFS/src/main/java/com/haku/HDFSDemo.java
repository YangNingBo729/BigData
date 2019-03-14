package com.haku;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 */
public class HDFSDemo {
    public static void main(String[] args) throws URISyntaxException, IOException {

        Configuration configuration = new Configuration();
        configuration.set("dfs.replication", "1");
        URI uri = new URI("hdfs://hadoop:9000");
        FileSystem fileSystem = FileSystem.get(uri, configuration);

        // 文件上传
//        Path src = new Path("F:\\百知资料\\13-大数据训练营\\6. hadoop资料\\workspace\\hdfs_demo\\src\\main\\java\\HDFSDemo.java");
//        Path dst = new Path("/user/root/cps/nb/3.wmv");
//        fileSystem.copyFromLocalFile(src,dst);


        // 文件下载
//        Path src = new Path("/usr/root/cps/nb/1.wmv");
//        Path dst = new Path("G:\\ChenPS\\20. \u8bad\u7ec3\u8425\\7. hadoop\u8d44\u6599\\000.wmv");
//
//        fileSystem.copyToLocalFile(src, dst);

        // 文件删除
        Path path = new Path("/user/root/cps/nb/3.wmv");
        boolean delete = fileSystem.delete(path, true);
        System.out.println(delete);

//        RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(new Path("/user/root/cps/nb"), true);
//        while (files.hasNext()){
//            LocatedFileStatus file = files.next();
//            System.out.println(file.getPath().toString());
//        }
//
//        fileSystem.setPermission(new Path("/user/root/cps/nb/3.wmv"),new
//                FsPermission(FsAction.ALL, FsAction.READ_WRITE, FsAction.READ));


        fileSystem.close();
    }
}