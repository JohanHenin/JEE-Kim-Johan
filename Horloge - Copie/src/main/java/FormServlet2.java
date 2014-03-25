

import java.io.IOException;

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
		
		response.getWriter().write(street + city + postalCode + name + age);
	}

}
