package com.oa.hjc.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oa.pub.bean.Manager;
import com.oa.hjc.service.UserService;
import com.oa.hjc.service.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	String errorMsg="";
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		UserService us=UserServiceImpl.getInstance();
		try {
			Manager u=us.login(name, pass);
			if(u==null)
			{
				//登录失败
				//response.getWriter().append("登录失败");
				request.getSession().setAttribute("errormsg", "登录失败用户名或密码错误");
				//request.getRequestDispatcher("/hjc/login.jsp").forward(request, response);//请求转发
				response.sendRedirect("hjc/login.jsp");
			}
			else
			{
				//登录成功
				//response.getWriter().append("登录成功");
				HttpSession session = request.getSession();
				                   // key  value
				session.setAttribute("user", u);//登录成功后，将当前登录用户信息放入session，以便其它页面使用
				/*
				System.out.println("sessionid="+session.getId());
				Enumeration<String> names = session.getAttributeNames();
				while(names.hasMoreElements()) {
					String key=names.nextElement();
					System.out.println(key+"=" +session.getAttribute(key));
				}
				*/
				response.sendRedirect("index.jsp");//重定向
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
