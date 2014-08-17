import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class addMember extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String name=request.getParameter("name");
   	String address=request.getParameter("address");
	String email=request.getParameter("email");
	String phn=request.getParameter("phn");
	String id=request.getParameter("id");
	String type=request.getParameter("type");

	
	try{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://127.0.0.1/lms";
	Connection con=DriverManager.getConnection(url,"root","123");
	Statement st=con.createStatement();
	
	//if(id.equals("\0") && name.equals("\0") && type.equals("\0"))
	//{
	String query="INSERT INTO member(Member_ID,Member_Name,Address,Phone_No, Email,Type)VALUES("+id+",'"+name+ "','"+ address+ "',"+phn+",'"+email+"','"+type+"') ";

	System.out.println(query);
	
	int res=st.executeUpdate(query);
	
	
	if(res==1){	
		//out.println("<html><head></head><body><h1>employee added</h1></body></html>");
		response.sendRedirect("AddMember2.html");
	}
	//}
	else{	response.sendRedirect("addMember3.html");
	}

	}
	catch(Exception e)
	{
		out.println(e);
	}

	}
}