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


//This class inserts the info of the new user into the DB

public class InsertNewUserIntoDB {

	PreparedStatement preparedStatementinsert ;
	boolean success=true;
	public static Connection dbCon;

	public  void NewUser (UserTuple newuser){
		//dbCon = null;
		dbCon=ConnectionManager.getConnection();
		String MyQuery= "INSERT INTO RegisteredUsers(Email,Fname,Lname,YearB,DayB,MonthB,Country,City,Gender,PassW) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try{
			//Outputting Result to the OUTPUT relation with TRANSACTION ID as well as the message of what happened
			preparedStatementinsert= dbCon.prepareStatement(MyQuery);
			
			preparedStatementinsert.setString(1, newuser.getEmail());
			preparedStatementinsert.setString(2, newuser.getFname());
			preparedStatementinsert.setString(3, newuser.getLname());
			preparedStatementinsert.setString(4, newuser.getYearB());
			preparedStatementinsert.setString(5, newuser.getDayB());
			preparedStatementinsert.setString(6, newuser.getMonthB());
			preparedStatementinsert.setString(7, newuser.getCountry());
			preparedStatementinsert.setString(8, newuser.getCity());
			preparedStatementinsert.setString(9, newuser.getGender());
			preparedStatementinsert.setString(10, newuser.getPassW());
		
			//preparedStatementinsert.setString(2, OutputMessage);
			
			preparedStatementinsert.executeUpdate();
			
			
			}catch(SQLException e){
				this.success=false;
				SQLExcept.handleException(e);
				e.printStackTrace();
			}	
	}
	
	
		
}
