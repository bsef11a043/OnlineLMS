import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.lang.*;


public class Login extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();

	String name=request.getParameter("username");
	String pswd=request.getParameter("password");
	
	/*Cookie c=new Cookie(name,password);
	c.setMaxAge(2*24*60*60);
	response.addCookie(c);*/

    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/lms";

    Connection con=DriverManager.getConnection(url,"root","123");

    Statement st=con.createStatement();

     
     String query = "Select Status from login where User_ID= "+ name+" AND Password= "+pswd;
    System.out.println(query);

      ResultSet rs = st.executeQuery( query );

     	if(rs.next())
	{	System.out.println("hello");
		String s=rs.getString("Status");
		System.out.println(s);
		if(s.equals("1"))
		{	System.out.println(rs.getString("Status").equals(1));
			response.sendRedirect("Menu.html"); 		
		}
	}
	else
	{	
		response.sendRedirect("login2.html"); 			
	}    

         st.close();
         con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
