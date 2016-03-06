package com.tboys.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.tboys.dao.DoRegisterDao;
import com.tboys.model.User;

public class DoRegisterDaoImpl implements DoRegisterDao{

	UserManageDaoImpl dumi;
	
	public DoRegisterDaoImpl(DataSource ds) {
		super();
		dumi = new UserManageDaoImpl(ds);
	}

	@Override
	public boolean judgeRegisterUser(User user) {
	
		try {
			if(dumi.find(user)) {
				System.out.println("���ֻ��ѱ�ע��,�����");
				return false;
			}else{
				dumi.save(user);
//				System.out.println(000);
			}
		} catch (SQLException e) {
			System.out.println("����������");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
