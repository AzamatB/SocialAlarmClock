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


public class Main {

	private static String DBDIRECTORY = "./Databases/";
	
	public static Connection dbCon;
	
	public static void main(String[] args) {
		
		try {
		    Class.forName(DBConstants.DB_DRIVER);
		} catch (ClassNotFoundException cfe) {		
			System.out.println("The JDBC drive loading failed.");
			cfe.printStackTrace();
		}
		try {	
			dbCon = DriverManager.getConnection(DBConstants.DB_NAME);
		} catch (SQLException se) {
			SQLExcept.handleException(se);	
		}
		
	
	
	}
}
