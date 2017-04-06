

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String name=request.getParameter("userName");  
		    String password=request.getParameter("userPass");  
		          
		    if(password.equals("bvcoe2014") && name.equals("Admin")){  
		        RequestDispatcher rd=request.getRequestDispatcher("/FrameSet.html");  
		        rd.forward(request, response);  
		    }  
		    else{  
		    	
		        out.print("<br><h1 style=font-family:sans-serif;color:white;text-align:center>Wrong Username And Password !!!</h1>");  
		        RequestDispatcher rd=request.getRequestDispatcher("/LoginPage.html");  
		        rd.include(request, response);  
		                      
		        }  
		    }  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
		  
		

	}
}
