package com.tboys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.tboys.dao.UserManageDao;
import com.tboys.listner.AppListner;
import com.tboys.model.User;
import com.tboys.util.DbHelper;

public class UserManageDaoImpl implements UserManageDao{

	//JDBC���������ݲ����Ľӿ�,�ɸ������̵�����ʵ��
	//Volley ���󹤳�ģʽ
	
	//Ԥ�������� ����
	//1 ���� ���ܺ�
	//������ ��ֹ SQLע��
	
	private PreparedStatement state;
	private ResultSet result;
	private String sql;
	
	private DataSource ds;
	private Connection conn;
	
	public UserManageDaoImpl(DataSource ds) {
		super();
		this.ds = ds;
	}

	//ע���˺�
	@Override
	public boolean save(User user) throws SQLException {
		// TODO Auto-generated method stub
		conn = ds.getConnection();
		sql = "insert into Users(id,account,password) values(seq_users_id.NEXTVAL,?,?)";
		state = conn.prepareStatement(sql);
		System.out.println(00000);
		state.setString(1, user.getAccout());
		state.setString(2, user.getPassword());
		boolean rigister = state.execute();
		DbHelper.close(null, state, conn);
		return rigister;
	}

	/**
	 * ���µ����û�
	 */
	@Override
	public int update(User user) throws SQLException {
		conn = ds.getConnection();
		sql = "update Users set password = ? where account = ?";
		state = conn.prepareStatement(sql);
		state.setString(1, user.getPassword());
		state.setString(2, user.getAccout());
		int n = state.executeUpdate();
		DbHelper.close(null, state, conn);
		return n;
	}

	@Override
	public void remove(User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ��ѯ����
	 */
	@Override
	public User find(String account) throws SQLException {
		conn = ds.getConnection();
		User user = new User();
		sql = "select * from users where account = ?";
		state = conn.prepareStatement(sql);
		state.setString(1, account);
		result = state.executeQuery();
		if(result.next()) {		
			user.setAccout(account);
			user.setPassword(result.getString(3));
		}
		DbHelper.close(result, state, conn);
		return user;
	}
	
	@Override
	public int QueryId(User user) throws SQLException {
		conn = ds.getConnection();
		sql = "select userId from users where account = ?";
		state = conn.prepareStatement(sql);
		int n = 0;
		state = conn.prepareStatement(sql);
		state.setString(1,user.getAccout());
		result = state.executeQuery();
		if(result.next()) {
			n = result.getInt(1);
		}
		DbHelper.close(result, state, conn);
		return n;
	}

	@Override
	public boolean find(User user) throws SQLException {
		conn = ds.getConnection();
		sql = "select * from users where account = ?";
		state = conn.prepareStatement(sql);
		state.setString(1, user.getAccout());
		result = state.executeQuery();
		if (result.next()) {
			DbHelper.close(result, state, conn);
			return true;
		}
		DbHelper.close(result, state, conn);
		return false;
	}
}
