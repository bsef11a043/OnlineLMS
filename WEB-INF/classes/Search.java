import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Search extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	out.println("<html>");
	out.println("<head>");
	out.println("<title>LMS-Search</title>");
	out.println("</head>");
	out.println("<body><div id='container' style='width:1155px;'><div id='header' style='background-color:6699FF;'><h1 style='font-family:calibri;margin-bottom:0'>Library Management System</h3>");
	out.println("</div><div id='menu' style='background-color:66CCFF;height:450px;width:200px;float:left;'><b><a href='Menu.html'>Menu</a></b><br><a href='AddMember.html'>Add_Member</a><br>");
	out.println("<a href='AddBook.html'>Add_Book</a><br>");
	out.println("<a href='BookList.html'>Book_List</a><br>");
	out.println("<a href='SearchBook.html'><b>Search_Book</b></a><br>");
	out.println("<a href='OrderBook.html'>Order_Book</a><br>");
	out.println("<a href='IssueBook.html'>Issue_Book</a><br>");
	out.println("<a href='BookStatus.html'>Update _Book Status</a><br>");
	out.println("<a href='MemberHistory.html'>Member_History</a><br>");
	out.println("<a href='Fine.html'>Fine</a><br>");
	out.println("<a href='addEmployee.html'>Add_Employee</a><br>");
	out.println("<a href='employeeInfo.html'>Employee_Information</a><br>");
	out.println("<a href='employeeSalary.html'>Employee_Salary</a><br>");
	out.println("<a href='employeeAttendance.html'>Mark_Attendance</a><br>");
	out.println("<a href='publisherInfo.html'>Publisher_Information</a><br>");
	out.println("<a href='publisherOrder.html'>Publisher_Order List</a><br>");
	out.println("<a href=''>Log out</a><br>");
	out.println("</div><div id='content' style='background-color:99FFFF;height:450px;width:955px;float:left;'><h2><b>Search Books</b></h2><br>");
	out.println("<form name='SearchBook' style='text-align:center' action='Search' method='post'>");
     	out.println("<input type='text' name='book' size='103'>&nbsp");
        out.println("<input type='submit' name='search' value='Go'></form>");
	
	

	String info=request.getParameter("book");
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1/lms";
		Connection con=DriverManager.getConnection(url,"root","123");
		Statement st=con.createStatement();	

		String query1, query2, query3, query4;
	
	
		query1="select * from book where ISBN= '"+info+"'";

		query2="select * from book where Title='"+info+"'";
		query3="select * from book where Author='"+info+"'";
		query4="select * from book where Category='"+info+"'";
		

		ResultSet res1=st.executeQuery(query1);
	
		if(res1.next())
		{
			
			out.println("<table border=5 align='center' bordercolor='#6699FF'><tr><td>ISBN</td><td> Author</td><td> Publisher_ID</td><td> Price</td><td>Category</td><td> Title </td></tr>");
			res1.previous();
			
			while(res1.next())
			{
				String isbn=res1.getString(1);
				String 	author=res1.getString(2);
				String publisher=res1.getString(3);
				float price=res1.getFloat(4);
				String category=res1.getString(5);
				String title=res1.getString(6);
				out.println("<tr><td>"+isbn+"</td><td>"+author+"</td><td>"+publisher+"</td><td>"+price+"</td><td>"+category+"</td><td>"+title+"</td></tr>");
			}
		}

		else 
		{
			ResultSet res2=st.executeQuery(query2);
			if(res2.next())
			{
				out.println("<table border=5 align='center' bordercolor='#6699FF'><tr><td>ISBN</td><td> Author</td><td> Publisher_ID</td><td>Price</td><td>Category</td><td> Title </td></tr>");
				res2.previous();
				while(res2.next())
				{
					String isbn=res2.getString(1);
					String 	author=res2.getString(2);
					String publisher=res2.getString(3);
					float price=res2.getFloat(4);
					String category=res2.getString(5);
					String title=res2.getString(6);
					out.println("<tr><td>"+isbn+"</td><td>"+author+"</td><td>"+publisher+"</td><td>"+price+"</td><td>"+category+"</td><td>"+title+"</td></tr>");
				}
			}

			else 
			{
				ResultSet res3=st.executeQuery(query3);
				if(res3.next())
				{
					out.println("<table border=5 align='center' bordercolor='#6699FF'><tr><td>ISBN</td><td> Author</td><td> Publisher_ID</td><td> Price</td><td> Category</td><td> Title </td></tr>");
					res3.previous();
					while(res3.next())
					{	
						String isbn=res3.getString(1);
						String 	author=res3.getString(2);
						String publisher=res3.getString(3);
						float price=res3.getFloat(4);
						String category=res3.getString(5);
						String title=res3.getString(6);
						out.println("<tr><td>"+isbn+"</td><td>"+author+"</td><td>"+publisher+"</td><td>"+price+"</td><td>"+category+"</td><td>"+title+"</td></tr>");
					}
				}

				else
				{
					ResultSet res4=st.executeQuery(query4);
					if(res4.next())
					{
						out.println("<table border=5 align='center' bordercolor='#6699FF'><tr><td>ISBN</td><td> Author</td><td> Publisher_ID</td><td>Price</td><td> Category</td><td> Title </td></tr>");
						res4.previous();
						while(res4.next())
						{	
							String isbn=res4.getString(1);
							String 	author=res4.getString(2);
							String publisher=res4.getString(3);
							float price=res4.getFloat(4);
							String category=res4.getString(5);
							String title=res4.getString(6);
							out.println("<tr><td>"+isbn+"</td><td>"+author+"</td><td>"+publisher+"</td><td>"+price+"</td><td>"+category+"</td><td>"+title+"</td></tr>");
						}
					}
					else
					{
						out.println("<h1>NOT FOUND</h1>");
					}
				
				}
			}//else of res3



		}//this is the first else

		
	out.println("</table></div></body></html>");	
		
	}
	catch(Exception e)
	{
      		out.println(e);
	}
	}
}
	
	
                                                                                                                                                                                                    	