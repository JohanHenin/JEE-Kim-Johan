package fr.epsi.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {

	private static final long serialVersionUID = -8710385077137206045L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward("inscription.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Inscription inscription = new Inscription();
		inscription.setLogin(req.getParameter("login"));
		inscription.setEmail(req.getParameter("email"));
		inscription.setConditionsGeneralesApprouvees(Boolean.parseBoolean(req.getParameter("conditionsGeneralesApprouvees")));

		try {
			inscription.validate();
			req.setAttribute("inscription", inscription);
			forward("inscriptionOk.jsp", req, resp);
		} catch (InscriptionInvalideException e) {
			req.setAttribute("errors", e.getErrorMessages());
			forward("inscription.jsp", req, resp);
		}
	}

	private void forward(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/" + page);
		dispatcher.forward(req, resp);
	}

}
