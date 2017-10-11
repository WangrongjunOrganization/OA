package com.oa.hjc.controller;

import com.oa.hjc.service.UserService;
import com.oa.hjc.service.UserServiceImpl;
import com.oa.pub.bean.SkDept;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


public class SkdeptServlet extends HttpServlet {

    String errorMsg = "";//验证失败的错误属性

    //UserInfo user; 解决并发访问问题的方法，不要定义这样的成员属性
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //必需 放在前面
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //接收来制客户端提交过来的参数

        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String tele = request.getParameter("tele");
        String fax = request.getParameter("fax");
        String discrip = request.getParameter("discrip");
        int sksuper = Integer.parseInt(request.getParameter("sksuper"));
        String createtime = request.getParameter("createtime");


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = format.parse(createtime);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //String remark=request.getParameter("remark");
        /*if(userName==null)
		{
			response.sendRedirect("../register.jsp");
			return;
		}*/
        //把接收到的参数组装成一个userInfo对象
        UserService us = UserServiceImpl.getInstance();

        SkDept ui = new SkDept(name, type, tele, fax, discrip, new SkDept(sksuper), date);
        if (!ui.validate()) {
            //response.sendRedirect("../register.jsp");
            response.getWriter().append(outText(ui.getValidateErrorMsg(), "/hjc/adddept.jsp"));//响应dhtml文档
            return;
        }
		/*
		try {
			if(us.getUserByName(userName)!=null)
			{
				response.getWriter().append(outText("注册失败，用户名已经存在","../register.jsp"));//响应dhtml文档
				return ;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			response.getWriter().append(outText("注册失败，用户名已经存在","../register.jsp"));//响应dhtml文档
			return;
		}
		*/

        //response.getWriter().append(""+userName+","+password1+","+sex+","+email+","+remark);

        //创建用户服务器类对象

        try {
            //调用服务对象的插入对象方法完成注册
            int c = us.insert(ui);
            if (c > 0)//根据返回值 ，判断成功与否
            {
                //注册成功，跳转至登录页登录
                //response.sendRedirect("../login.jsp");
                response.setContentType("text/html");
                PrintWriter ps = response.getWriter();
                ps.append(outText("添加成功!", "idex.jsp"));
            } else {// 重新注册
                response.sendRedirect("/hjc/adddept.jsp");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//		String str="";//有指向对象，对象中没有一个字符
//		str="    ";//有指向对象，对象中有多个字符，但都是空格字符
//		str=null;//没有指向任何对象
//	
    }
//	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
//	{
//		doGet(request,response);
//	}
//	

    String outText(String message, String url) {
        return "<html>\r\n" +
                "<head>\r\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" +
                "<title>Insert title here</title>\r\n" +
                "</head>\r\n" +
                "<body>\r\n" +
                "<script>alert('" + message + "');location.href='" + url + "'; </script>" +
                "\r\n" +
                "</body>\r\n" +
                "</html>";
    }
}

