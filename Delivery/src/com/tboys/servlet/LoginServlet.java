package com.tboys.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.tboys.dao.impl.DoLoginDaoImpl;
import com.tboys.dao.impl.DoRegisterDaoImpl;
import com.tboys.listner.AppListner;
import com.tboys.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	public static final String USER = "user";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println(request.getRequestURI());

		String account = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		System.out.println(account+pwd);
		HttpSession session = request.getSession();

		ServletContext application = getServletContext();
		DataSource ds = (DataSource) application.getAttribute(AppListner.DATE_SOURCE);
//		Connection conn = null;
//		try {
//			conn = ds.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		DoLoginDaoImpl dldi = new DoLoginDaoImpl(ds);
		User user = new User(account, pwd);
		System.out.println(user.toString());
		int isSucced = dldi.judgeLoginUser(user);
		if (isSucced == 1) {
			// 登录成功将用户信息存在会话中
			session.setAttribute(USER, user);
			response.getWriter().write("200");
		} else if(isSucced == 0){
			
			response.getWriter().write("403");
		}else if(isSucced == -1){
			
			response.getWriter().write("405");
		}else{
			response.getWriter().write("500");
		}
	}

}
