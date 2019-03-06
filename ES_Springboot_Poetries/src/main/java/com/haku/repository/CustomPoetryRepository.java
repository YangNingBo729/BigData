package com.haku.repository;

import com.haku.entity.PoetryES;

import java.util.List;

public interface CustomPoetryRepository {
    //根据关键词和类型 查询
    List<PoetryES> search(String type, String key);
}
