package com.haku;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDfsSpringBootApplicationTests {

    @Autowired
    private FastFileStorageClient storageClient;

    /*文件上传*/
    @Test
    public void testUpload() throws FileNotFoundException {
        File file = new File("E:\\a.pdf");
        FileInputStream inputStream = new FileInputStream(file);
        StorePath storePath = storageClient.uploadFile(inputStream,
                file.length(), "pdf", null);
        System.out.println(storePath.getGroup() + " | " +
                storePath.getPath());
    }

    /*文件下载*/
    @Test
    public void testDownload() throws IOException {
        byte[] b = storageClient.downloadFile("group1",
                "M00/00/00/wKiUilx0Rd-AX0e0AAB6tiPkjUw776.xml", new DownloadByteArray());
        FileOutputStream fileOutputStream = new
                FileOutputStream("E:\\aa.xml");
        fileOutputStream.write(b);
        fileOutputStream.close();
    }

}
