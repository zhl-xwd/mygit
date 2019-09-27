package com.cs.web.dao;

import java.util.List;

import com.cs.web.model.TTest;



public interface TTestMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(TTest record);

    int insertSelective(TTest record);

    TTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TTest record);

    int updateByPrimaryKey(TTest record);
    
    
    List<TTest> selectAll();
}