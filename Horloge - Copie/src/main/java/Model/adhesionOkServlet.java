package Model;


import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adhesionOkServlet
 */
@WebServlet("/adhesionOkServlet")
public class adhesionOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adhesionOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
                                        	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date_actuelle = new Date();
		String dateString = DateFormat.getDateInstance(DateFormat.FULL).format(date_actuelle);
	    String timeString = DateFormat.getTimeInstance(DateFormat.FULL).format(date_actuelle);
	    request.setAttribute("heure", timeString);
	    request.setAttribute("date", dateString);
		request.getRequestDispatcher("/adhesionvalide.jsp").forward(request, response);

	}

}
