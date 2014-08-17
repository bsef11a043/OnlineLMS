import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class addBook extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String id=request.getParameter("id");
   	String isbn=request.getParameter("isbn");
	String author=request.getParameter("author");
	String publisher=request.getParameter("publisher");
	String price=request.getParameter("price");
	String category=request.getParameter("category");
	String title=request.getParameter("title");
	String status=request.getParameter("status");
	
	try{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://127.0.0.1/lms";
	Connection con=DriverManager.getConnection(url,"root","123");
	Statement st=con.createStatement();

	String query1="INSERT INTO book(isbn,author,publisher,price,category,title)VALUES("+isbn+",'"+author+"','"+publisher+"',"+price+",'"+category+"','"+title+"')";
	String query="INSERT INTO bookStatus(book_id,isbn,status)VALUES("+id+","+isbn+",'"+status+"') ";
	
	System.out.println(query);
	
	int res=st.executeUpdate(query1);
	
	int res1=st.executeUpdate(query);
	if(res==1 && res==1){	
		//out.println("<html><head></head><body><h1>employee added</h1></body></html>");
		response.sendRedirect("AddBook2.html");
	}
	else{	response.sendRedirect("AddBook3.html");
	}

	}
	catch(Exception e)
	{
		out.println(e);
	}

	}
}