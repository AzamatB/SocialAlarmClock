package SocialAlarmClockJava;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class LoggedInUsers {
	private Connection dbCon;
	
	public  void StoreSession(String email, String Session){
		System.out.println("asdsadssdasadsadsad");
		dbCon=ConnectionManager.getConnection();
		String MyQuery= "INSERT INTO LoggedInUsers(Email,SessionID) VALUES(?,?)";
		PreparedStatement preparedStatementinsert ;
		try{
			//Outputting Result to the OUTPUT relation with TRANSACTION ID as well as the message of what happened
			preparedStatementinsert= dbCon.prepareStatement(MyQuery);
			
			preparedStatementinsert.setString(1, email);
			preparedStatementinsert.setString(2, Session);
				
			preparedStatementinsert.executeUpdate();
			
			
			}catch(SQLException e){
				//this.success=false;
				SQLExcept.handleException(e);
				e.printStackTrace();
			}	
	}
	
	
}
