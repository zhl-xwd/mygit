package com.cs.web.service;

import com.cs.web.model.TTest;
import com.cs.web.module.utils.PageReq;
import com.github.pagehelper.PageInfo;

public interface TTestService {

	public TTest selectByPrimaryKey(Long id);
	
	public PageInfo<TTest> page(PageReq pageReq);
	
}
