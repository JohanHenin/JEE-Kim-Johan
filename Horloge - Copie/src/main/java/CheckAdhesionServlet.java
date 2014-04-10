

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckAdhesionServlet
 */
@WebServlet("/CheckAdhesionServlet")
public class CheckAdhesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdhesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String login = request.getParameter("login");
		String email = request.getParameter("email");
		
		if (checkMail(email) && checkLogin(login)){
			request.getRequestDispatcher("adhesionOkServlet").forward(request, response);
			
		}
		else{
				
		}

	}
	
	private boolean checkMail(String email){
		boolean mailValide = false;
		
		return true;
	}
	
	private boolean checkLogin(String login){
		boolean loginValide = false;
		
		return true;
	}

}
