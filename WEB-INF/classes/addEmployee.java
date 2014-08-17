import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class addEmployee extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String name=request.getParameter("ename");
   	String address=request.getParameter("address");
	String email=request.getParameter("email");
	String phn=request.getParameter("phn");
	String id=request.getParameter("empid");
	String des=request.getParameter("des");

	
	try{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://127.0.0.1/lms";
	Connection con=DriverManager.getConnection(url,"root","123");
	Statement st=con.createStatement();
	
	String query="INSERT INTO employee(Employee_ID,Employee_Name,Designation,Address,Phone_No, Email)VALUES("+id+",'"+name+ "','"+des+"','" + address+ "',"+phn+",'"+email+"') ";

	System.out.println(query);
	
	int res=st.executeUpdate(query);
	
	
	if(res==1){	
		//out.println("<html><head></head><body><h1>employee added</h1></body></html>");
		response.sendRedirect("http://localhost:8080/LMS/addEmployee3.html");
	}
	else{	response.sendRedirect("http://localhost:8080/LMS/addEmployee2.html");
	}

	}
	catch(Exception e)
	{
		out.println(e);
	}

	}
}