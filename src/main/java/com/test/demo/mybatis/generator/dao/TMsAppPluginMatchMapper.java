package com.test.demo.mybatis.generator.dao;

import com.test.demo.mybatis.generator.model.TMsAppPluginMatch;

public interface TMsAppPluginMatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMsAppPluginMatch record);

    int insertSelective(TMsAppPluginMatch record);

    TMsAppPluginMatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMsAppPluginMatch record);

    int updateByPrimaryKey(TMsAppPluginMatch record);
}