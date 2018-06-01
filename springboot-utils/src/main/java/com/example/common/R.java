package com.example.common;

import java.util.HashMap;
import java.util.Map;

public class R {
	
	public static Map<String, Object> ok() {
		return ok("成功");
	}
	
	public static Map<String, Object> ok(String msg) {
		return ok("0", msg);
	}

	public static Map<String, Object> ok(Map<String, Object> data) {
		return ok("0", "成功",data);
	}

	public static Map<String, Object> ok(String code, String msg) {
		return ok(code,msg, null);
	}

	private static Map<String, Object> ok(String code,String msg,Map<String, Object> data) {
		Map<String, Object> rm = new HashMap<String, Object>();
		rm.put("code", code);
		rm.put("msg", msg);
		rm.put("data", data);
		return rm;
	}
	
	public static Map<String, Object> error() {
		return error("未知错误");
	}
	
	public static Map<String, Object> error(String msg) {
		return error("1", msg);
	}

	private static Map<String, Object> error(String code, String msg) {
		Map<String, Object> rm = new HashMap<String, Object>();
		rm.put("code", code);
		rm.put("msg", msg);
		return rm;
	}
	
	public static Map<String, Object> finished(String code, String msg) {
		Map<String, Object> rm = new HashMap<String, Object>();
		rm.put("code", code);
		rm.put("msg", msg);
		return rm;
	}
	
	public static Map<String, Object> ing(String msg) {
		return error("2", msg);
	}
	
}
