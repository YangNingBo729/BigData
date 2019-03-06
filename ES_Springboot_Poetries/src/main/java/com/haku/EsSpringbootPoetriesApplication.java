package com.haku;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@MapperScan("com.haku.dao")
@EnableElasticsearchRepositories(basePackages = "com.haku.dao.es")
public class EsSpringbootPoetriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsSpringbootPoetriesApplication.class, args);
    }

}
