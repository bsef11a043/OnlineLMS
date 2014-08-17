
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.lang.*;

public class issue extends HttpServlet {
  
  	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title=request.getParameter("title");
		String isbn=request.getParameter("isbn");
		HttpSession s=request.getSession();
		if(s==null)
			response.sendRedirect("memberMenu.html");
		else{
		Integer mid=(Integer)s.getAttribute("user");
		
		System.out.println(mid);
		
		try{
			Class.forName("com.sql.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1/ip";
			Connection con=DriverManager.getConnection(url,"root","123");
			Statement st=con.createStatement();
			
			String query="select bookStatus.status,bookStatus.book_ID from bookStatus,book where book.ISBN=bookStatus.ISBN and book.Title='"+title+"'";
			System.out.println(query);
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				String status=rs.getString("status");
				String bid=rs.getString("Book_ID");
				if(status.equals("available"))
				{
					String query1="UPDATE bookStatus Set status='unavailable' where book_ID="+bid;
					int res=st.executeUpdate(query1);
					System.out.println(query1);
					if(res==1){
						String q="select max(issue_ID) from issue";
						ResultSet r=st.executeQuery(q);
						int i=r.getInt(1);
						String query2="Insert INTO issue(issue_ID,member_ID,book_ID,Issue_Date,Due_Date,Return_Date) values("+i+","+mid+","+bid+",CURDATE(),CURDATE()+7,CURDATE()+7)";
						int res1=st.executeUpdate(query2);
						if(res1==1){
							out.println("<html><head></head><body><h1>Book issued successfully</h1></body></html>");
						}
						else
						{	
							out.println("<html><head></head><body><h1>Error issuing book</h1></body></html>");
						}
					}
					else
					{	
						out.println("<html><head></head><body><h1>Error issuing book</h1></body></html>");
					}
				}
			}
		}
		catch(Exception e)
		{
			out.println(e);	
		}
	}
	}
}