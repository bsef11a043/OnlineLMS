import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class BookStatus extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	/*
	out.println("<html>");
	out.println("<head>");
	out.println("<title>LMS-Search</title>");
	out.println("</head>");
	out.println("<body><div id='container' style='width:1155px;'><div id='header' style='background-color:6699FF;'><h1 style='font-family:calibri;margin-bottom:0'>Library Management System</h3>");
	out.println("</div><div id='menu' style='background-color:66CCFF;height:450px;width:200px;float:left;'><b><a href='Menu.html'>Menu</a></b><br><a href='AddMember.html'>Add_Member</a><br>");
	out.println("<a href='AddBook.html'>Add_Book</a><br>");
	out.println("<a href='BookList.html'>Book_List</a><br>");
	out.println("<a href='SearchBook.html'>Search_Book</a><br>");
	out.println("<a href='OrderBook.html'>Order_Book</a><br>");
	out.println("<a href='IssueBook.html'>Issue_Book</a><br>");
	out.println("<a href='BookStatus.html'><b>Update _Book Status</b></a><br>");
	out.println("<a href='MemberHistory.html'>Member_History</a><br>");
	out.println("<a href='Fine.html'>Fine</a><br>");
	out.println("<a href='addEmployee.html'>Add_Employee</a><br>");
	out.println("<a href='employeeInfo.html'>Employee_Information</a><br>");
	out.println("<a href='employeeSalary.html'>Employee_Salary</a><br>");
	out.println("<a href='employeeAttendance.html'>Mark_Attendance</a><br>");
	out.println("<a href='publisherInfo.html'>Publisher_Information</a><br>");
	out.println("<a href='publisherOrder.html'>Publisher_Order List</a><br>");
	out.println("<a href=''>Log out</a><br>");
	out.println("</div><div id='content' style='background-color:99FFFF;height:450px;width:955px;float:left;'><h2><b>Search Books</b></h2><br>");*/
	
	

	String info=request.getParameter("id");

	String info1=request.getParameter("status");
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1/lms";
		Connection con=DriverManager.getConnection(url,"root","123");
		Statement st=con.createStatement();	

		String query1, query2;
	
		query1="UPDATE bookstatus SET status='"+info1+"'" + "WHERE book_ID=" + info;
		int r=st.executeUpdate(query1);
		if(r==1)
			response.sendRedirect("UpdateBookStatusSuccess.html");		

	}
	catch(Exception e)
	{
      		out.println(e);
	}

   }
}
	
	
                                                                                                                                                                                                    	













































