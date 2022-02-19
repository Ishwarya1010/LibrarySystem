package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DataAccessObject.BooksDAO;
import Model.Books;
/**
 * Servlet implementation class BooksServlet
 */

@WebServlet("/BooksServlet")
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private BooksDAO booksdao=new BooksDAO();
    public BooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/AddBook.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String book_name=request.getParameter("book_name");
		String book_publisher=request.getParameter("book_publisher");
		String book_edition=request.getParameter("book_edition");
		
		
		Books book=new Books();
		book.setBook_name(book_name);
		book.setBook_publisher(book_publisher);
		book.setBook_edition(book_edition);
		  try {
	            booksdao.registerBook(book);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		  request.getRequestDispatcher("/WEB-INF/views/ViewBooks.jsp").forward(request, response);
	      
	}

}
