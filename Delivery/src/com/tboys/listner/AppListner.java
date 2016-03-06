package com.tboys.listner;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class AppListner implements ServletContextListener {

    public static final String DATE_SOURCE = "date_source";

    public AppListner() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	
    	ServletContext application = event.getServletContext();
    	
    	Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/delivery");
			System.out.println("初始化数据库连接 (连接池)");
			application.setAttribute(DATE_SOURCE, ds);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
