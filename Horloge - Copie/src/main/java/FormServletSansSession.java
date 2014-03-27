

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
					request.setCharacterEncoding("utf-8");
					String userName = request.getParameter("userName");
					String userAge = request.getParameter("userAge");
					
					// Vérifier les paramètres passés par le formulaire
					if (checkUserName(userName) && checkUserAge(userAge))
					{
						// Créer le 2nd formulaire 
						response.setContentType("text/html");  
				        PrintWriter printWriter = response.getWriter(); 
						CreateSecondForm(printWriter, userName, userAge);
						printWriter.close(); 
					}
					else
					{
						response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Âge ou Nom mal renseigné");
					}
					
					break;
				}
				case "where":
				{
					request.setCharacterEncoding("utf-8");
					String userName = request.getParameter("userName");
					String userAge = request.getParameter("userAge");
					String street = request.getParameter("userStreet");
					String city = request.getParameter("userCity");
					String postalCode = request.getParameter("userPostalCode");
					
					if (checkUserName(userName) && checkUserAge(userAge) && checkAddress(street,city,postalCode))
					{
						response.getWriter().write("Nom: " + userName + "\n" +
								"Age: " + userAge + " ans" + "\n" +
								"Adresse : " + street + " " + postalCode + " " + city);
					}
					else{
						response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Une ou plusieurs information(s) est/sont mal renseignee(s)");
					}
					
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
	
	/*
	 * Fonctions to check form data
	 */
	
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
	
	private boolean checkAddress(String street, String city, String postalCode){
		boolean AddressOk = false;
		Pattern pattern = Pattern.compile("[0-9]{5}");
		Matcher matcher = pattern.matcher(postalCode);
		if (matcher.matches() && !"".equals(street) && !"".equals(city))
		{
			AddressOk = true;
		}
		return AddressOk;
	}
	
	/*
	 * Fonction to create the 2nd form
	 */
	
	private void CreateSecondForm(PrintWriter p_printWriter, String p_userName, String p_userAge)
	{
		try
		{
			//creating form that have invisible textfield  
			p_printWriter.print("<form action='FormServletSansSession' method='post' accept-charset='utf-8'>");  
			p_printWriter.print("Rue : <input type='text' name='userStreet' />");  
			p_printWriter.print("Code Postal : <input type='text' name='userPostalCode'/> ");
			p_printWriter.print("Ville : <input type='text' name='userCity' />"); 
			p_printWriter.print("<input type='hidden' name='userName' value='"+p_userName+"'/>");  
			p_printWriter.print("<input type='hidden' name='userAge' value='"+p_userAge+"'/>");  
			p_printWriter.print("<input type='hidden' name='action' value='where'/>");  
			p_printWriter.print("<input type='submit' />");  
			p_printWriter.print("</form>");     
		}
		catch (Exception e)
		{
			System.out.println(e);
		}  
	}

}
