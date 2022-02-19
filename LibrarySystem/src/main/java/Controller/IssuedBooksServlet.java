package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObject.IssuedBooksDAO;
import Model.Books;
import Model.IssuedBooks;
import Model.Users;

/**
 * Servlet implementation class IssuedBooksServlet
 */
@WebServlet("/IssuedBooksServlet")
public class IssuedBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssuedBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/Issue.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IssuedBooksDAO issuedbooksdao=new IssuedBooksDAO();

		int uid=Integer.parseInt(request.getParameter("userid"));
		int bid=Integer.parseInt(request.getParameter("bookid"));
		String issueddate=request.getParameter("issueddate");
		
		
		Books book=new Books();
		Users user=new Users();
		IssuedBooks issuedbook=new IssuedBooks();
		book.setBid(bid);
		user.setUid(uid);
		issuedbook.setIssuedDate(issueddate);
		  try {
			  issuedbooksdao.issueBook(book,user,issuedbook);	
			
	        } 
		  catch (Exception e) {
	            e.printStackTrace();
	        }
		  request.getRequestDispatcher("/WEB-INF/views/ViewIssuedBooks.jsp").forward(request, response);
		 
	}

}
