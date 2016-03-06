package com.tboys.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.tboys.dao.DoLoginDao;
import com.tboys.model.User;

public class DoLoginDaoImpl implements DoLoginDao{

	UserManageDaoImpl dumi;
	
	public DoLoginDaoImpl(DataSource ds) {
		super();
		dumi = new UserManageDaoImpl(ds);
	}

	@Override
	public int judgeLoginUser(User user) {
		
		//获得客户端的信息
		String account = user.getAccout();
		String password = user.getPassword();
		System.out.println(password);
		
		//从数据库查询,并判断
		try {
			User u = dumi.find(account);
			System.out.println("444"+u.toString());
			System.out.println("测试");
				if(u.getPassword().equals(password)){
					System.out.println("登陆成功");
					return 1;
				}else{
					System.out.println("密码错误");
					return 0;
				}
			
		} catch (SQLException e) {
			System.out.println("该手机号未注册");
			e.printStackTrace();
			return -2;
		} catch(NullPointerException e) {
			System.out.println("该手机号未注册");
			e.printStackTrace();
			return -1;
		}
	}
}
