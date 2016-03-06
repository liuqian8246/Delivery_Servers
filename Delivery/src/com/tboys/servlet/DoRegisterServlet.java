package com.tboys.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.tboys.dao.impl.DoRegisterDaoImpl;
import com.tboys.listner.AppListner;
import com.tboys.model.User;

/**
 * Servlet implementation class DoRegisterServlet
 */
public class DoRegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String account = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		System.out.println(account + pwd);
		ServletContext application = getServletContext();
		DataSource ds = (DataSource) application.getAttribute(AppListner.DATE_SOURCE);

		DoRegisterDaoImpl drdi = new DoRegisterDaoImpl(ds);
		if (account != null && pwd != null) {
			boolean isSucced = drdi.judgeRegisterUser(new User(account, pwd));
			if(isSucced){
				System.out.println("�ɹ�");
				//�ظ����ͻ���
				response.getWriter().write("200");
			}else{
				response.getWriter().write("403");
			}
		}else{
			System.out.println("�û��������벻��Ϊ��");
		}
	}

}
