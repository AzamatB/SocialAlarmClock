package SocialAlarmClockJava;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


@WebServlet("/GetUserDetails") //Name of the servlet
public class GetUserDetails extends HttpServlet {
 
		
//@Override
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
    
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
    String docType ="<!DOCTYPE HTML>\n";
    String title = "You have been registered by the following details";
    out.println(docType +"<HTML>\n" +"<HEAD>+<TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=CENTER>\n" + "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>Parameter Name<TH>Parameter Value(s)");
    Enumeration<String> paramNames = request.getParameterNames();

    int counter = 0;
    while(paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
         
      out.print("<TR><TD>" + paramName + "\n<TD>");
      //out.println(paramName);
      String[] paramValues = request.getParameterValues(paramName);
      if (paramValues.length == 1) {
        String paramValue = paramValues[0];
        if (paramValue.length() == 0)
          out.println("<I>No Value</I>");
        else
          out.println(paramValue);
      } else {
        out.println("<UL>");
        for(int i=0; i<paramValues.length; i++) {
          out.println("<LI>" + paramValues[i]);

        }
        out.println("</UL>");
      }
      counter++;
    }
    out.println("</TABLE>\n</BODY></HTML>");
 
    
    UserTuple newuser= new UserTuple(request.getParameter("Fname"),request.getParameter("Lname"),request.getParameter("YearB"),//Storing the just recieved info into a new temp user variable 
    request.getParameter("DayB"),request.getParameter("MonthB"),request.getParameter("Gender"),request.getParameter("Country"),
    request.getParameter("City"),request.getParameter("Email"),request.getParameter("PassW"));
    InsertNewUserIntoDB NewUserGoingIn = new InsertNewUserIntoDB();
    NewUserGoingIn.NewUser(newuser);  //Storing the User permanently    
    response.sendRedirect("Login.jsp"); 
  
  }

    

 /*public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request, response);
  }*/
}

