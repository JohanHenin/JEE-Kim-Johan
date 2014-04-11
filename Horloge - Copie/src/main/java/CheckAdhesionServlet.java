

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String approuve = request.getParameter("approuve"); // "on" si cochée sinon ""
		
		if (checkMail(email) && checkLogin(login) && checkApprouve(approuve)){
			request.getRequestDispatcher("adhesionOkServlet").forward(request, response);
		}
		else{
		    // Renvoyer les paramètres pour les réafficher
            request.setAttribute("login", login);
            request.setAttribute("email", email);
            request.setAttribute("approuve", approuve);

            // gestion du message d'erreur
            if(!checkLogin(login))
                request.setAttribute("wrongLogin", "Login trop court (5 caractères min)");
            if(!checkMail(email))
                request.setAttribute("wrongEmail", "Email non conforme");
            if(!checkApprouve(approuve))
                request.setAttribute("wrongApprouve", "Veuillez cocher les conditions générale svp");

            request.getRequestDispatcher("/adhesion.jsp").forward(request, response);
		}

	}

    private boolean checkMail(String email){
		boolean mailValide = false;

        Pattern pattern = Pattern.compile("[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches())
        {
            mailValide = true;
        }
		
		return mailValide;
	}
	
	private boolean checkLogin(String login){
		boolean loginValide = false;

        // Vérifier le login
        if( (! "".equals(login) ) && (login.length() >= 5) )
        {
            loginValide = true;
        }

		return loginValide;
	}

    private boolean checkApprouve(String approuve)
    {
        boolean approuveValide = false;

        if("on".equals(approuve))
        {
            approuveValide = true;
        }

        return approuveValide;
    }
}
