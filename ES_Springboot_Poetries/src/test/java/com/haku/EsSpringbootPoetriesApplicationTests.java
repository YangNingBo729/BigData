package com.haku;

import com.haku.dao.PoetryEsMapper;
import com.haku.dao.es.PoetryRepository;
import com.haku.entity.PoetryES;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsSpringbootPoetriesApplicationTests {
    //    @Autowired
//    private PoetMapper poetMapper;
    @Autowired
    private PoetryRepository poetryRepository;
    @Autowired
    private PoetryEsMapper poetryEsMapper;

    @Test
    public void addEs() {
        List<PoetryES> poetryES = poetryEsMapper.selectAll();
        poetryRepository.saveAll(poetryES);
    }
//    @Test
//    public void contextLoads() {
//        Poet poet = poetMapper.selectByPrimaryKey(1);
//        System.out.println(poet);
//    }

    @Test
    public void testInsert() {
        poetryRepository.save(new PoetryES("1", "1", "诗人", "标题", "内容", new Date()));

    }


}
