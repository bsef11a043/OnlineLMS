import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class employeeSalary2 extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	out.println("<html>");
	out.println("<head>");
	out.println("<title>LMS-EmployeeInfo</title>");
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
	out.println("</div><div id='content' style='background-color:99FFFF;height:450px;width:955px;float:left;'><h2><b>Employee Salary</b></h2><br>");

	String info=request.getParameter("employee");
	
	try{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://127.0.0.1/lms";
	Connection con=DriverManager.getConnection(url,"root","123");
	Statement st=con.createStatement();

	String query;
	out.println("<table border=5 align='center' bordercolor='#6699FF'><tr><td>ID</td><td> Name</td><td>Salary</td></tr>");
	
	query="select e.employee_id,e.employee_name,s.salary from salary s, employee e where s.Employee_ID=e.Employee_ID and e.Employee_Name='"+info+"'";
	
	System.out.println(query);
	ResultSet res=st.executeQuery(query);
	
	
	while(res.next())
	{
		String id=res.getString(1);
		String 	name=res.getString(2);
		String sal=res.getString(3);
		
		out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+sal+"</td></tr>");
	}
	out.println("</table>");
	out.println("<br><a href='employeeSalary.html'>Go Back</a>");
	out.println("</div><div id='footer' style='background-color:6699FF;clear:both;text-align:center;'>LMS</div></div></body></html>");
	}
	catch(Exception e)
	{
	out.println(e);
	}
	}
}
	
	
	