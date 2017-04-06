

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditDatabase
 */
@WebServlet("/EditDatabase")
public class EditDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDatabase() {
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
		          
		
		String rollno=request.getParameter("rollno"); 
		
	
		try{  

		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/regform","root","root");
		  
		out.print("<style>body{ background:#292931;}</style>");   
        PreparedStatement ps=con.prepareStatement("select Name,EnrollmentNo,FirstSem,SecondSem,ThirdSem,FourthSem,FifthSem from studentDatabase where "
        		+ "EnrollmentNo="+rollno+";");
 
        out.print("<style>"
        		+ ".label{ color:white;font-family:sans-serif;font-weight:bold;}"
        		+ "body{background:#292931;}"
        		+ "</style>");
        ResultSet rs=ps.executeQuery();
        out.print("<caption><h1 style=font-family:sans-serif;color:white;text-align:center><u>ENTER NEW ENTRIES</u></h1></caption>");
      
        out.print("<table>");
        while(rs.next()){
        out.print("<tr><td><form action=NewEntryDatabase method=post></td></tr>");
        out.print("<tr><td><label class=label>NAME:</label></td><td><input type=text name=name value="+rs.getString(1)+"></td></tr>");
        out.print("<tr><td><label class=label>ROLL NO:</label></td><td><input type=text name=rollno value="+rs.getString(2)+" readonly></td></tr>");
        out.print("<tr><td><label class=label>BRANCH:</label></td><td><select class=input name=branch><option>CS</option><option>IT</option</select></td></tr>");
        out.print("<tr><td><label class=label>1st SEM:</label></td><td><input type=text name=1sem value="+rs.getString(3)+"></td></tr>");
        out.print("<tr><td><label class=label>2nd SEM:</label></td><td><input type=text name=2sem value="+rs.getString(4)+"></td></tr>");
        out.print("<tr><td><label class=label>3rd SEM:</label></td><td><input type=text name=3sem value="+rs.getString(5)+"></td></tr>");
        out.print("<tr><td><label class=label>4th SEM:</label></td><td><input type=text name=4sem value="+rs.getString(6)+"></td></tr>");
        out.print("<tr><td><label class=label>5th SEM:</label></td><td><input type=text name=5sem value="+rs.getString(7)+"></td></tr>");
        out.print("<tr><td><input type=submit value=SUBMIT id=btn-submit class=input></td></tr>");
        out.print("<tr><td></form></td></tr>");
       }
        out.print("</table>");
       
	    
		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
}
