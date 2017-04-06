

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
 * Servlet implementation class NewEntryDatabase
 */
@WebServlet("/NewEntryDatabase")
public class NewEntryDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEntryDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String name=request.getParameter("name"); 
		String rollno=request.getParameter("rollno"); 
		String branch=request.getParameter("branch");  
		String firstsem=request.getParameter("1sem");  
		String secondsem=request.getParameter("2sem");
		String thirdsem=request.getParameter("3sem");
		String fourthsem=request.getParameter("4sem");
		String fifthsem=request.getParameter("5sem");
	
		          
		try{  

		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/regform","root","root");
		  
		PreparedStatement ps=con.prepareStatement(  
		"update studentDatabase set Name=?,EnrollmentNo=?,Branch=?,FirstSem=?,SecondSem=?,ThirdSem=?,FourthSem=?,FifthSem=? where EnrollmentNo="+rollno+";");  
		ps.setString(1,name); 
		ps.setString(2,rollno);
		ps.setString(3,branch);  
		ps.setString(4,firstsem);  
		ps.setString(5,secondsem); 
		ps.setString(6,thirdsem);  
		ps.setString(7,fourthsem);  
		ps.setString(8,fifthsem); 
        int i=ps.executeUpdate();  
		if(i>0){
			 RequestDispatcher rd=request.getRequestDispatcher("/Edit.html");  
		        rd.include(request, response);  
		                      
		}  
		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
		
	

}
