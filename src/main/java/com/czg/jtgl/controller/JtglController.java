package com.czg.jtgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.czg.jtgl.dao.JtglDAO;
import com.czg.jtgl.model.Bdjg;
import com.czg.jtgl.service.jtglManager;
import com.czg.jtgl.webmodel.User;

@Controller 
public class JtglController {
	private jtglManager jtManager = new jtglManager(); 
	
	@RequestMapping(value="/findUserId")
       public ModelAndView findUserId(HttpServletRequest request,HttpServletResponse response){
		      ServletContext context=request.getSession().getServletContext();
	    	  ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
	    	  JtglDAO dao=(JtglDAO)ctx.getBean("JtglDAO"); 
    	   List<Bdjg> list  = dao.findYpjgRegcomByUserid("com_000510");
    	   Map m = new HashMap();
    	   m.put("cs", list.size());
    	   return new ModelAndView("index",m);
	   }
	   /**
	    * 登录
	    * @param request
	    * @param response
	    * @author czg
	    * @return
	    */
	   @RequestMapping(value="/login")
	   public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		   String username=jtManager.getParameterForController(request, "username");
		   String password=jtManager.getParameterForController(request, "password");
		   HttpSession session = request.getSession();
		   User u = new User();
		   u.setUsername(username);
		   u.setPassword(password);
		   session.setAttribute("user", u);
		   Map m = new HashMap();
		   m.put("username", username);
		   return new ModelAndView("index",m);
	   }
	   
	   
}
