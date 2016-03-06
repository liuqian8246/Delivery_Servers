package com.tboys.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tboys.model.Record;
import com.tboys.model.User;

public interface RecordDao {
	

	/**
	 * ������ԤԼ��¼
	 * @return
	 */
	boolean insertRecord(Record record,User user)throws SQLException ;
	/**
	 * ���ԤԼ��¼����
	 * @return
	 */
	int countRecord(User user)throws SQLException ;
	/**
	 * ��ѯ����ԤԼ��¼
	 * @return
	 */
	ArrayList<Record> findRecord(User user)throws SQLException ;
	

	
}
