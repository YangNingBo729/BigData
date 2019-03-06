package com.haku.repository;

import com.haku.entity.PoetryES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Repository
public class CustomPoetryRepositoryImpl implements CustomPoetryRepository {
    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public List<PoetryES> search(String type, String key) {
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(matchQuery(type, key))
                .build();
        List<PoetryES> poetryList = template.queryForList(query, PoetryES.class);
//        for (PoetryES p : poetryList) {
//            System.out.println(p);
//        }
        return poetryList;
    }
}
