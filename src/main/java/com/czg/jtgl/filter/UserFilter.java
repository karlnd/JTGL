package com.czg.jtgl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserFilter implements Filter{
	    private FilterConfig filterConfig; 
		/**
		 * 登录过滤
		 */
          public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException, ServletException{
        	  System.out.println("过滤前"); 
        	  HttpServletRequest req = (HttpServletRequest) request;
      		HttpServletResponse res = (HttpServletResponse) response;
      		HttpSession session = req.getSession();
        	  String requestUri = req.getRequestURI();//端口后面的URL
        	  if (requestUri.endsWith("/login.jsp")) {
  				chain.doFilter(request, response);
        	  }else if (requestUri.endsWith(".css")
  						|| requestUri.endsWith(".js")
  						|| requestUri.endsWith(".jpg")
  						|| requestUri.endsWith(".JPG")
  						|| requestUri.endsWith(".jpeg")
  						|| requestUri.endsWith(".JPEG")
  						|| requestUri.endsWith(".bmp")
  						|| requestUri.endsWith(".BMP")
  						|| requestUri.endsWith(".gif")
  						|| requestUri.endsWith(".GIF")
  						|| requestUri.endsWith(".png")
  						|| requestUri.endsWith(".PNG")
  						|| requestUri.endsWith(".avi")
  						|| requestUri.endsWith(".AVI")
  						|| requestUri.endsWith(".wmv")
  						|| requestUri.endsWith(".WMV")
  						|| requestUri.endsWith(".wma")
  						|| requestUri.endsWith(".WMA")
  						|| requestUri.endsWith(".mpeg")
  						|| requestUri.endsWith(".MPEG")
  						|| requestUri.endsWith(".rm") || requestUri.endsWith(".RM")
  						|| requestUri.endsWith(".ram")
  						|| requestUri.endsWith(".RAM")
  						|| requestUri.endsWith(".swf")
  						|| requestUri.endsWith(".SWF")) {// 若是图片、视频、css、javascript，则不做过滤
  					chain.doFilter(request, response);
        	  }else{
        		// 获得认证用户信息---------单点登录
  				Object u = session.getAttribute("user");
  				if(u==null){
					// session失效
					res.sendRedirect(req.getContextPath() + "/login.jsp");
				}
  				 chain.doFilter(request, response);
        	  }
        	  
        	  //放行。让其走到下个链或目标资源中 
              System.out.println("过滤后"); 
          }  
          
          public void init(FilterConfig filterConfig) throws ServletException { 
              System.out.println("初始化了"); 
              this.filterConfig = filterConfig; 
          } 
          public void destroy() { 
              System.out.println("销毁了"); 
          } 
}
