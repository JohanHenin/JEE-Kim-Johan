

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Horloge
 */
@WebServlet("/Horloge")
public class Horloge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Horloge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    Date date_actuelle = new Date();
	    
	    // Set date in fr
	    String dateString = DateFormat.getDateInstance(DateFormat.FULL).format(date_actuelle);
	    String timeString = DateFormat.getTimeInstance(DateFormat.FULL).format(date_actuelle);
	    
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("utf-8");
	    response.getWriter().write(dateString+" "+timeString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
