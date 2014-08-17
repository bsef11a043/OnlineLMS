import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class memberHistory extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	out.println("<html>");
	out.println("<head>");
	out.println("<title>LMS-MemberHistory</title>");
	out.println("</head>");
	out.println("<body><div id='container' style='width:1155px;'><div id='header' style='background-color:6699FF;'><h1 style='font-family:calibri;margin-bottom:0'>Library Management System</h3>");
	out.println("</div><div id='menu' style='background-color:66CCFF;height:450px;width:200px;float:left;'><b><a href='Menu.html'>Menu</a></b><br><a href='AddMember.html'>Add_Member</a><br>");
	out.println("<a href='AddBook.html'>Add_Book</a><br>");
	out.println("<a href='BookList.html'>Book_List</a><br>");
	out.println("<a href='SearchBook.html'>Search_Book</a><br>");
	out.println("<a href='OrderBook.html'>Order_Book</a><br>");
	out.println("<a href='IssueBook.html'>Issue_Book</a><br>");
	out.println("<a href='BookStatus.html'>Update _Book Status</a><br>");
	out.println("<a href='MemberHistory.html'>Member_History</a><br>");
	out.println("<a href='Fine.html'>Fine</a><br>");
	out.println("<a href='addEmployee.html'>Add_Employee</a><br>");
	out.println("<a href='employeeInfo.html'><b>Employee_Information</b></a><br>");
	out.println("<a href='employeeSalary.html'>Employee_Salary</a><br>");
	out.println("<a href='employeeAttendance.html'>Mark_Attendance</a><br>");
	out.println("<a href='publisherInfo.html'>Publisher_Information</a><br>");
	out.println("<a href='publisherOrder.html'>Publisher_Order List</a>");
	out.println("<a href=''>Log out</a><br>");
	out.println("</div><div id='content' style='background-color:99FFFF;height:450px;width:955px;float:left;'><h2><b>Member History</b></h2><br>");

	String info=request.getParameter("id");
	try{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://127.0.0.1/lms";
	Connection con=DriverManager.getConnection(url,"root","123");
	Statement st=con.createStatement();
	//out.println("<table border=5 align='center' bordercolor='#6699FF'><tr><td>ID</td><td> Name</td><td>Salary</td></tr>");
	String query="select member.member_id, member.member_name,bookstatus.Book_ID,bookstatus.ISBN,issue.Isuue_Date,issue.Return_Date from member,bookstatus,issue where member.member_ID=issue.Member_ID and issue.Book_Id=bookstatus.Book_ID and member.Member_ID="+info;
	ResultSet r=st.executeQuery(query);
	out.println("<table border=5 align='center' bordercolor='#6699FF'><tr><td>ID</td><td> Name</td><td>Book ID</td><td> ISBN</td><td> Issue Date</td><td> Return Date</td></tr>");
	while(r.next()){
		//out.println("hello");
		String id=r.getString(1);
		String name=r.getString(2);
		String bid=r.getString(3);
		String isbn=r.getString(4);
		String idate=r.getString(5);
		String rdate=r.getString(6);
		out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+bid+"</td><td>"+isbn+"</td><td>"+idate+"</td><td>"+rdate+"</td></tr>");
	}
	
	
	}catch(Exception e)
	{
		out.println(e);
	}
}
}
	
	