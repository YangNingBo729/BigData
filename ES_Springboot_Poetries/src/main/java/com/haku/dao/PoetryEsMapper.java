package com.haku.dao;

import com.haku.entity.PoetryES;

import java.util.List;

public interface PoetryEsMapper {
    //查询出所有PoetryEs
    List<PoetryES> selectAll();
}
