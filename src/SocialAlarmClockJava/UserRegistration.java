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
import java.io.*; 

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import SocialAlarmClockJava.SQLExcept;
import SocialAlarmClockJava.DBConstants;
import SocialAlarmClockJava.SQLExcept;


public class UserRegistration {

	private static Connection dbCon ;
	PreparedStatement preparedStatementinsert ;

	public UserRegistration() {
		
		
		intializedatabase();
		}
	
	
	public static void intializedatabase() {
		dbCon = ConnectionManager.getConnection();
	}
	
	public void NewUser (String[] attributesNames,String[] paramValues){
		//dbCon = null;
		String MyQuery= "INSERT INTO RegisteredUsers(Email,Fname,Lname,YearB,DayB,MonthB,Country,City,Gender,PassW) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try{
			//Outputting Result to the OUTPUT relation with TRANSACTION ID as well as the message of what happened
			preparedStatementinsert= dbCon.prepareStatement(MyQuery);
			for (int i=0; i<11; i++){
			preparedStatementinsert.setString((i+1), paramValues[i]);
			//preparedStatementinsert.setString(2, OutputMessage);
			}
			preparedStatementinsert.executeUpdate();
			
			
			}catch(SQLException e){
				SQLExcept.handleException(e);
				e.printStackTrace();
			}
	}
	
	
	
}
