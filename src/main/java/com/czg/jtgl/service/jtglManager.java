package com.czg.jtgl.service;

import javax.servlet.http.HttpServletRequest;

public class jtglManager {
    /**
     * 获得参数
     * @param request
     * @param pararName
     * @return
     */
	public String getParameterForController(HttpServletRequest request,
			String pararName) {
		String s = request.getParameter(pararName);
		return (null == s) ? "" : s;
	}
	  
}
