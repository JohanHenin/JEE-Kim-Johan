

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		request.setCharacterEncoding("utf-8");

		
            // Vérifier les paramètres passés par le formulaire
            String nom = checkUserName(request, response);
            String age = checkUserAge(request, response);
            // Afficher les bons paramètres
			response.getWriter().write(nom + " " + age + " ans");
		

		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");

	}

    private String checkUserName(HttpServletRequest p_request, HttpServletResponse p_response) throws IOException
    {
        String name = "";

        // Vérifier le nom
        if(p_request.getParameter("userName") != null)
        {
            name = p_request.getParameter("userName")+" ";
        }
        else
        {
            p_response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nom mal rensigné");
        }

        return name;
    }


    private String checkUserAge(HttpServletRequest p_request, HttpServletResponse p_response) throws IOException
    {
        String age = "";

        // Vérifier l'âge
        if(Integer.valueOf(p_request.getParameter("userAge")) > 0)
        {
            age = p_request.getParameter("userAge");
        }
        else
        {
            p_response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Âge négatif");
        }

        return age;
    }
}
