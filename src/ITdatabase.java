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
 * Servlet implementation class ITdatabase
 */
@WebServlet("/ITdatabase")
public class ITdatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ITdatabase() {
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

		String name=request.getParameter("name").trim(); 
		String rollno=request.getParameter("rollno").trim(); 
		String branch=request.getParameter("branch").trim();  
		String firstsem=request.getParameter("1sem").trim();  
		String secondsem=request.getParameter("2sem").trim();
		String thirdsem=request.getParameter("3sem").trim();
		String fourthsem=request.getParameter("4sem").trim();
		String fifthsem=request.getParameter("5sem").trim();


		try{ 
			
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/regform","root","root");

				PreparedStatement ps=con.prepareStatement(  
						"insert into studentDatabase values(?,?,?,?,?,?,?,?)");  

				ps.setString(1,name); 
				ps.setString(2,rollno);
				ps.setString(3,branch);  
				ps.setString(4,firstsem);  
				ps.setString(5,secondsem); 
				ps.setString(6,thirdsem);  
				ps.setString(7,fourthsem);  
				ps.setString(8,fifthsem); 

				ps.executeUpdate();  
			
			RequestDispatcher rd=request.getRequestDispatcher("/Main.html");  
			rd.include(request, response);  


		}catch (Exception e2) {System.out.println(e2);}  

		out.close();  
	}  
}
