

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		try
		{
			if (Integer.valueOf(request.getParameter("userAge")) > 0  && request.getParameter("userName") != null)
			{
				String age = request.getParameter("userAge");
				String nom = request.getParameter("userName");
				response.getWriter().write(nom + " " + age + " ans");
			}
			else
			{
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Âge négatif ou le nom est mal renseigné"); 
			}

		}
		catch(NumberFormatException e)
		{
			response.getWriter().write("L'âge n'est pas entier");
		}

		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");

	}

}
