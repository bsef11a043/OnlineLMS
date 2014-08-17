import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class bookHistory extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	Cookie c[]=request.getCookies();
	String name;
	String password;
	for(int i=0;i<c.length;i++)
	{

		name=c[i].getName();
		password=c[i].getValue();
	}
	
	try{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://127.0.0.1/lms";
	Connection con=DriverManager.getConnection(url,"root","123");
	Statement st=con.createStatement();
	
	
	String query="";

	System.out.println(query);
	
	ResultSet res=st.executeUpdate(query);
	
	
	while(next()){	
		//out.println("<html><head></head><body><h1>employee added</h1></body></html>");
		response.sendRedirect("AddMember2.html");
	}
	else{	response.sendRedirect("addMember3.html");
	}

	}
	catch(Exception e)
	{
		out.println(e);
	}

	}
}