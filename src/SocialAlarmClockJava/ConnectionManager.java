package SocialAlarmClockJava;

import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SocialAlarmClockJava.DBConstants;
import SocialAlarmClockJava.SQLExcept;


public class ConnectionManager {
	static Connection dbCon;
	
	public static Connection getConnection()  {
		
		try {
		    Class.forName(DBConstants.DB_DRIVER);
		} catch (ClassNotFoundException cfe) {		
			System.out.println("The JDBC drive loading failed.");
			cfe.printStackTrace();
		}
		try {	
			dbCon = DriverManager.getConnection(DBConstants.DB_NAME);
	//		System.out.print("asasdads");
		} catch (SQLException se) {
			SQLExcept.handleException(se);	
		}
		
		return dbCon;
	
	}
}
