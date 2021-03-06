package com.haku.dao;

import com.haku.entity.Poet;

public interface PoetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Poet record);

    int insertSelective(Poet record);

    Poet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Poet record);

    int updateByPrimaryKey(Poet record);
}