

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deletedatabase
 */
@WebServlet("/Deletedatabase")
public class Deletedatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletedatabase() {
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
		              
		PreparedStatement ps=con.prepareStatement("delete from  studentDatabase where EnrollmentNo= "+rollno+";");  
		
		 
		  
		int i=ps.executeUpdate();  
		if(i>0){
			 RequestDispatcher rd=request.getRequestDispatcher("/Delete.html");  
		        rd.include(request, response);  
		                      
		}
		else{
			 RequestDispatcher rd=request.getRequestDispatcher("/Delete.html");  
		        rd.include(request, response);  
		        out.print("<br><h3 style=font-family:sans-serif;color:white;>NOT FOUND !!!</h3>");
		}
		              
		
		              
		}catch (Exception e2) {e2.printStackTrace();}  
		          
		finally{
			out.close();
		}  
		

		doGet(request, response);
	}

}
