package com.haku.repository;

import com.haku.entity.PoetryES;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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
                .withHighlightFields(new HighlightBuilder.Field(type).preTags("<span style=\"color:red\">").postTags("</span>"))
                .build();
        // List<PoetryES> poetryList = template.queryForList(query, PoetryES.class);
        AggregatedPage<PoetryES> poetryES = template.queryForPage(query, PoetryES.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                ArrayList<PoetryES> poetryESList = new ArrayList<>();
                SearchHits searchHits = searchResponse.getHits();
                for (SearchHit searchHit : searchHits) {
                    if (searchHits.getHits().length <= 0) {
                        return null;
                    }
                    PoetryES poetryES = new PoetryES();
                    poetryES.setPoet_id(searchHit.getSourceAsMap().get("poet_id").toString());
                    poetryES.setPoetry_id(searchHit.getSourceAsMap().get("poetry_id").toString());
                    if (searchHit.getHighlightFields().get("title") == null) {
                        poetryES.setTitle(searchHit.getSourceAsMap().get("title").toString());
                    } else {
                        String title =
                                searchHit.getHighlightFields().get("title").fragments()[0].toString();
                        poetryES.setTitle(title);
                        System.out.println(title);
                    }
                    if (searchHit.getHighlightFields().get("name") == null) {
                        poetryES.setName(searchHit.getSourceAsMap().get("name").toString());
                    } else {
                        String name =
                                searchHit.getHighlightFields().get("name").fragments()[0].toString();
                        poetryES.setName(name);
                        System.out.println(name);
                    }
                    if (searchHit.getHighlightFields().get("content") == null) {
                        poetryES.setContent(searchHit.getSourceAsMap().get("content").toString());
                    } else {
                        String content =
                                searchHit.getHighlightFields().get("content").fragments()[0].toString();
                        poetryES.setContent(content);
                        System.out.println(content);
                    }

                    poetryES.setCreated(new Date(Long.parseLong(searchHit.getSourceAsMap().get("created").toString())));
                    //new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format( searchHit.getSourceAsMap().get("created"))
                    poetryESList.add(poetryES);
                }
                return new AggregatedPageImpl<T>((List<T>) poetryESList);
            }

        });
//        for (PoetryES p : poetryList) {
//            System.out.println(p);
//        }
        return poetryES.getContent();
    }
}
