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
		
		//��ÿͻ��˵���Ϣ
		String account = user.getAccout();
		String password = user.getPassword();
		System.out.println(password);
		
		//�����ݿ��ѯ,���ж�
		try {
			User u = dumi.find(account);
			System.out.println("444"+u.toString());
			System.out.println("����");
				if(u.getPassword().equals(password)){
					System.out.println("��½�ɹ�");
					return 1;
				}else{
					System.out.println("�������");
					return 0;
				}
			
		} catch (SQLException e) {
			System.out.println("���ֻ���δע��");
			e.printStackTrace();
			return -2;
		} catch(NullPointerException e) {
			System.out.println("���ֻ���δע��");
			e.printStackTrace();
			return -1;
		}
	}
}
