

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Finddatabase
 */
@WebServlet("/Finddatabase")
public class Finddatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Finddatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		          
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/regform","root","root");
		String rollno=request.getParameter("rollno"); 	  
		out.print("<style>body{ background:#292931;}</style>"); 
		out.print("<h1 style=font-family:sans-serif;color:white;text-align:center;><u>STUDENT DETAILS</u></h1><br><br>");
		PreparedStatement ps=con.prepareStatement("select * from  studentDatabase where EnrollmentNo= "+rollno+";");  
		out.print("<table width=100% border=1>");  
		
		  
		ResultSet rs=ps.executeQuery();  
		              
		/* Printing column names */  
		ResultSetMetaData rsmd=rs.getMetaData();  
		int total=rsmd.getColumnCount();  
		out.print("<tr>");  
		for(int i=1;i<=total;i++)  
		{  
		out.print("<th style=font-family:sans-serif;color:white;>"+rsmd.getColumnName(i)+"</th>");  
		}  
		  
		out.print("</tr>");  
		              
		/* Printing result */  
		  
		while(rs.next())  
		{  
		out.print("<tr style=font-family:sans-serif;color:white>"
				+ "<td>"+rs.getString(1)+"</td>"
				+ "<td>"+rs.getString(2)+"</td>"
				+ "<td>"+rs.getString(3)+"</td>"
				+ "<td>"+rs.getString(4)+"</td>"
				+ "<td>"+rs.getString(5)+"</td>"
				+ "<td>"+rs.getString(6)+"</td>"
				+ "<td>"+rs.getString(7)+"</td>"
				+ "<td>"+rs.getString(8)+"</td>"
				+ "</tr>");  
		                  
		}  
		  
		out.print("</table>");  
		 
		  
		}catch (Exception e2) {e2.printStackTrace();}  
		          
		finally{
			out.close();
		}  
		

		doGet(request, response);
	}
}
