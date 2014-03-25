import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
public class LogServlet extends HttpServlet {

  private static final long serialVersionUID = 7446985734933559486L;

  @Override
  public void init() throws ServletException {
    this.log("################################# init " + getServletName());
  }

  @Override
  public void destroy() {
    this.log("################################# destroy " + getServletName());
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                      throws ServletException, IOException {
	this.log("################################# called successfully " + getServletName());
    resp.setCharacterEncoding("utf-8");
    resp.setContentType("text/plain");
    resp.getWriter().write(getServletName() + " called successfully");
  }

}