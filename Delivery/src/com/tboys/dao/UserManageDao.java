package com.tboys.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.tboys.model.User;

public interface UserManageDao {

	/**
	 * ע��
	 * @param user
	 * @return �ɹ�true
	 * @throws SQLException
	 */
	boolean save(User user) throws SQLException;
	
	/**
	 * ��������
	 * @param User user
	 * @throws SQLException
	 */
	int update(User user) throws SQLException;
	
	/**
	 * ɾ������
	 * @param User user
	 * @throws SQLException
	 */
	void remove(User user) throws SQLException;
	
	int QueryId(User user)throws SQLException;
	
	/**
	 * ��ѯ����  һ��
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	User find(String account) throws SQLException;
	
	boolean find(User user) throws SQLException;
}
