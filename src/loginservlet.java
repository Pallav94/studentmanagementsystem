

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        PrintWriter out=response.getWriter();  
        
          
        String name=request.getParameter("userName");  
        String password=request.getParameter("userPass");  
          
        if(password.equals("bvcoe2014")&& name.equals("Admin")){  
       // out.print("Welcome, "+name);  
        HttpSession session=request.getSession();  
        session.setAttribute("name",name);  
        request.getRequestDispatcher("FrameSet.html").include(request, response);  
        }  
        else{  
        	out.print("<br><h2 style=font-family:sans-serif;color:white;text-align:center;>Wrong Username and Password !!!</h2>"); 
        	request.getRequestDispatcher("LoginPage.html").include(request, response);
             
        }  
        out.close();  
    }  
		    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
		  
		

	}
}
