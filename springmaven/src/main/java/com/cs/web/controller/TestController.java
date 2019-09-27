package com.cs.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.web.GatewayProtocol;
import com.cs.web.model.TTest;
import com.cs.web.module.utils.PageReq;
import com.cs.web.service.TTestService;
import com.github.pagehelper.PageInfo;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/springmaven/ttest/select")
public class TestController {

	@Autowired
	TTestService tTestService;	

    
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	@GetMapping("/test")
	public JSONObject test(HttpServletRequest req) {
		try {
			TTest tTest = tTestService.selectByPrimaryKey(1L);
			if(null == tTest) {
				return GatewayProtocol.protocolBody(GatewayProtocol.RET_FAIL, null, "");
			}

			return GatewayProtocol.protocolBody(GatewayProtocol.RET_SUCCESS, tTest, "");

		}catch(Exception e) {
			e.printStackTrace();
		}

		return GatewayProtocol.protocolBody(GatewayProtocol.RET_FAIL, null, "");
	}

	//只接受get方式的请求 请求
	@GetMapping("/page")
	public JSONObject page(PageReq pageReq) {
		try {
			PageInfo<TTest> page = tTestService.page(pageReq);
			if(null == page) {
				return GatewayProtocol.protocolBody(GatewayProtocol.RET_FAIL, null, "");
			}

			return GatewayProtocol.protocolBody(GatewayProtocol.RET_SUCCESS, page, "");

		}catch(Exception e) {
			e.printStackTrace();
		}

		return GatewayProtocol.protocolBody(GatewayProtocol.RET_FAIL, null, "");
	}	
	
	//到loop请求由loop()处理 
	@RequestMapping("loop")
	public String loop() {
		
		JSONObject json=new JSONObject();
		try {
			for (int i = 1; i <=10000; i++) {
				json.put(i+"", i);
				
				
				log.info("循环到第"+i+"个");
				
				Thread.sleep(i);
				
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return json.toJSONString();
		
	}
}
