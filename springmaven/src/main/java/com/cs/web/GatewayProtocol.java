package com.cs.web;

import net.minidev.json.JSONObject;

public class GatewayProtocol {
	public static final String RET_SUCCESS = "0";
	public static final String RET_FAIL = "1";
	
	public static JSONObject protocolBody(String ret,Object data,String msg){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ret", ret);
		jsonObject.put("data", data);
		jsonObject.put("msg", msg == null ? "" : msg);
		return jsonObject;
	}
}
