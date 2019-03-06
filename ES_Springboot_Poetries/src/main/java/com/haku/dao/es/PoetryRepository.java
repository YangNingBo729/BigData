package com.haku.dao.es;

import com.haku.entity.PoetryES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PoetryRepository extends ElasticsearchRepository<PoetryES, String> {

}
