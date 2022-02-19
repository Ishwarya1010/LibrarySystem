package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DataAccessObject.LoginDAO;
import Model.Users;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO logindao=new LoginDAO();
		PrintWriter out = response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Users user=new Users();
		user.setUsername(username);
		user.setPassword(password);
		 try {
			int result= logindao.loginTry(user);
			request.setAttribute("UserId",user.getUid());
		if(result==1)
			request.getRequestDispatcher("/WEB-INF/views/AdminFunctions.jsp").forward(request, response);
	else if(result==2)			
		request.getRequestDispatcher("/WEB-INF/views/UserFunctions.jsp").forward(request, response);

		else 
		{
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('User or password incorrect');");
			   out.println("location='Login.jsp';");
			   out.println("</script>");
			} 
	} 
		 catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		 

}}
