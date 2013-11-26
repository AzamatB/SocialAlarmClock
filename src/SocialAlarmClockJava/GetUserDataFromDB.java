package SocialAlarmClockJava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetUserDataFromDB {

	private Connection dbCon;
	private String queryString;
	
	
	//s	Iterator inputIterator;

	//public GetUserDataFromDB(Connection dbConnection) {
	//	dbCon = dbConnection;
		//queryString = "SELECT * from INPUT order by UserID asc";//Selecting everything from the INPUT relation
	//}

	public List GetAllUsersData() {
		dbCon=ConnectionManager.getConnection();
		List inputList = new ArrayList();

		
		if (dbCon == null) {
			return inputList;
		}
		//If connection is existant, collect all data from the INPUT relation
		Statement statement;
		ResultSet resultSet = null;
		try {
			statement = dbCon.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM  RegisteredUsers");
			while (resultSet.next()) {
				//collecting all data from INPUT
				String Email = resultSet.getString("Email");
				String Fname = resultSet.getString("Fname");
				String Lname = resultSet.getString("Lname");
				String YearB = resultSet.getString("YearB");
				String DayB = resultSet.getString("DayB");
				String MonthB = resultSet.getString("MonthB");
				String Gender = resultSet.getString("Gender");
				String Country = resultSet.getString("Country");
				String City = resultSet.getString("City");
				String PassW = resultSet.getString("PassW");
				UserTuple User = new UserTuple(Fname,Lname,YearB,DayB,MonthB,Gender,Country,City,Email,PassW);//all data above makes one tuple,one transaction

				inputList.add(User);//Number of users
			}

			resultSet.close();
			statement.close();
		} catch (SQLException se) {
			SQLExcept.handleException(se);
			se.printStackTrace();
		}
		
	//	this.inputIterator = inputList.iterator();
		return inputList;
	}
}
