package SocialAlarmClockJava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetUserDataFromDB GatherUserData = new GetUserDataFromDB();
		List CompareUser =  new ArrayList();
		CompareUser = GatherUserData.GetAllUsersData();
		boolean Success = false;
		CheckLoginDetails CheckLoginDetailsVar = new CheckLoginDetails (CompareUser,request.getParameter("Email"),request.getParameter("PassW"));
		Success = CheckLoginDetailsVar.confirmlogin();
		
		if (Success)
			response.sendRedirect("MembersHome.jsp"); 
			
		else
			response.sendRedirect("LoginFailed.jsp");
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
