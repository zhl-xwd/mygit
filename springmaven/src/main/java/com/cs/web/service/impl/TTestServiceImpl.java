package com.cs.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.web.dao.TTestMapper;
import com.cs.web.model.TTest;
import com.cs.web.module.utils.PageReq;
import com.cs.web.service.TTestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;




@Service
public class TTestServiceImpl implements TTestService{

	@Autowired
	TTestMapper tTestMapper;
	
	@Override
	public TTest selectByPrimaryKey(Long id) {
		return tTestMapper.selectByPrimaryKey(id.intValue());
	}

	@Override
	public PageInfo<TTest> page(PageReq pageReq) {
		
		PageHelper.startPage(pageReq.getPage(), pageReq.getSize());
		
		List<TTest> tTestes = tTestMapper.selectAll();
		
		PageInfo<TTest> pageInfo = new PageInfo<>(tTestes, 10);
		return pageInfo;
	}

}
