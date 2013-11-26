package SocialAlarmClockJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WakeUpRequest {

	
	public int phoneNum;
	
	
	public int timeHours;
	int timeMinutes;
	String userEmail;
	private static Connection dbCon;
	PreparedStatement preparedStatementinsert;

	public WakeUpRequest(String UserEmailMember) {

		this.userEmail = UserEmailMember;
		intializedatabase();
	}

	public static void intializedatabase() {

		dbCon = ConnectionManager.getConnection();
		/*
		 * try { Class.forName(DBConstants.DB_DRIVER); } catch
		 * (ClassNotFoundException cfe) {
		 * System.out.println("The JDBC drive loading failed.");
		 * cfe.printStackTrace(); } try {
		 * 
		 * } catch (SQLException se) { SQLExcept.handleException(se); }
		 */
	}

	public void NewUser(String[] attributesNames, String[] paramValues) {
		// dbCon = null;
		String MyQuery = "INSERT INTO RegisteredUsers(Email,Fname,Lname,YearB,DayB,MonthB,Country,City,Gender,PassW) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			// Outputting Result to the OUTPUT relation with TRANSACTION ID as
			// well as the message of what happened
			preparedStatementinsert = dbCon.prepareStatement(MyQuery);
			for (int i = 0; i < 11; i++) {
				preparedStatementinsert.setString((i + 1), paramValues[i]);
				// preparedStatementinsert.setString(2, OutputMessage);
			}
			preparedStatementinsert.executeUpdate();

		} catch (SQLException e) {
			SQLExcept.handleException(e);
			e.printStackTrace();
		}
	}

}
