

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

		String name = request.getParameter("userName");
		String age = request.getParameter("userAge");
		// Vérifier les paramètres passés par le formulaire
		if (checkUserName(name) && checkUserAge(age))
		{
			response.getWriter().write(name+ " " + age + " ans");
		}
		else
		{
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Âge ou Nom mal renseigné");
		}


	}

	private boolean checkUserName(String name)
	{
		
		boolean nameEstValide;
		// Vérifier le nom
		if(name != "")
		{
			nameEstValide = true;
		}
		else
		{
			nameEstValide = false;
		}

		return nameEstValide;
	}


	boolean checkUserAge(String age)
	{
		
		boolean ageEstValide = false;
		try
		{
			if(Integer.valueOf(age) > 0)
			{
				ageEstValide = true;
			}
		
		}
		catch(Exception e){
			
		}

		return ageEstValide;
	}
}
