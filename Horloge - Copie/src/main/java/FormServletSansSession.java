

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServletSansSession
 */
@WebServlet("/FormServletSansSession")
public class FormServletSansSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServletSansSession() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Page de départ
    	response.sendRedirect("formulaireSansSession1.html");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		if(checkAction(action))
		{
			switch(action)
			{
				case "who":
				{
					String name = request.getParameter("userName");
					String age = request.getParameter("userAge");
					
					// Vérifier les paramètres passés par le formulaire
					if (checkUserName(name) && checkUserAge(age))
					{
						
						response.sendRedirect("formulaireSansSession2.html?name="+name+"&age="+age);
					}
					else
					{
						response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Âge ou Nom mal renseigné");
					}
					
					break;
				}
				case "where":
				{
					// Récupérer URL
					StringBuffer requestURL = request.getRequestURL();
					if (request.getQueryString() != null) {
					    requestURL.append("?").append(request.getQueryString());
					}
					String completeURL = requestURL.toString();
					
					System.out.println(completeURL);
					
					break;
				}
				default :
				{
					// Ne fait rien mais redirige au début
					response.sendRedirect("formulaireSansSession1.html");
				}
			}
		}
		
	}
	
	private boolean checkAction(String p_action)
	{
		boolean actionEstValide;
		// Vérifier le nom
		if(! "".equals(p_action) )
		{
			if(p_action.equals("who") || p_action.equals("where"))
			{
				actionEstValide = true;
			}
			else
			{
				actionEstValide = false;
			}
		}
		else
		{
			actionEstValide = false;
		}

		return actionEstValide;
	}
	
	private boolean checkUserName(String name)
	{
		
		boolean nameEstValide;
		// Vérifier le nom
		if(! "".equals(name))
		{
			nameEstValide = true;
		}
		else
		{
			nameEstValide = false;
		}

		return nameEstValide;
	}


	private boolean checkUserAge(String age)
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
