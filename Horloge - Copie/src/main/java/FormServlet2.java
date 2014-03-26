

import java.io.IOException;
import java.util.regex.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet2
 */
@WebServlet("/FormServlet2")
public class FormServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		String name = (String) request.getSession().getAttribute("userName");
		String age = (String) request.getSession().getAttribute("userAge");
		if (checkAddress(street,city,postalCode)){
			response.getWriter().write("Nom: " + name + "\n" +
					"Age: " + age + " ans" + "\n" +
					street + " " + postalCode + " " + city);
		}
		else{
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Une ou plusieurs information(s) est/sont mal renseignee(s)");
		}

	}

	private boolean checkAddress(String street, String city, String postalCode){
		boolean AddressOk = false;
		Pattern pattern = Pattern.compile("[0-9]{5}");
		Matcher matcher = pattern.matcher(postalCode);
		if (matcher.matches() && !"".equals(street) && !"".equals(city)){
			AddressOk = true;
		}
		return AddressOk;
	}

}
