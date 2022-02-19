package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObject.ReturnedBooksDAO;
import Model.Books;
import Model.IssuedBooks;
import Model.ReturnedBooks;

/**
 * Servlet implementation class ReturnedBooksServlet
 */
@WebServlet("/ReturnedBooksServlet")
public class ReturnedBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnedBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/ReturnBook.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnedBooksDAO returnedbooksdao=new ReturnedBooksDAO();
		int issueid=Integer.parseInt(request.getParameter("issueid"));
		String returndate=request.getParameter("returndate");
		IssuedBooks ibooks=new IssuedBooks();
		ReturnedBooks rbooks=new ReturnedBooks();
		ibooks.setIssuedId(issueid);
		rbooks.setReturn_date(returndate);
		  try {
			  returnedbooksdao.returnBook(ibooks,rbooks);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		  request.getRequestDispatcher("/WEB-INF/views/ViewIssuedBooks.jsp").forward(request, response);
	      
	}

}
