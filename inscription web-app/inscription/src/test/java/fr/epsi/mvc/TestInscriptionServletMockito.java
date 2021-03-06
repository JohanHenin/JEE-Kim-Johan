package fr.epsi.mvc;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


public class TestInscriptionServletMockito
{
	HttpServletRequest mockitoRequest;
	HttpServletResponse mockitoResponse;
	InscriptionServlet inscriptionServlet;

	@Before
	public void setUp() throws Exception
	{
		mockitoRequest = mock(HttpServletRequest.class);
		mockitoResponse = mock(HttpServletResponse.class);

		inscriptionServlet = new InscriptionServlet();
	}

	 @Test
	  public void testDemoMockito() throws Exception
	  {
	        when(mockitoRequest.getParameter("login")).thenReturn("me");
	        when(mockitoRequest.getParameter("email")).thenReturn("testemail@gmail.com");
	        when(mockitoRequest.getParameter("conditionsGeneralesApprouvees")).thenReturn("true");

	        String parameterValueLogin = mockitoRequest.getParameter("login");
	        String parameterValueEmail = mockitoRequest.getParameter("email");
	        String parameterValueconditionsGeneralesApprouvees = mockitoRequest.getParameter("conditionsGeneralesApprouvees");

	        assertThat(parameterValueLogin, is("me") );
	        assertThat(parameterValueEmail, is("testemail@gmail.com") );
	        assertThat(parameterValueconditionsGeneralesApprouvees, is("true") );

	        verify(mockitoRequest).getParameter("login");
	        verify(mockitoRequest).getParameter("email");
	        verify(mockitoRequest).getParameter("conditionsGeneralesApprouvees");
	  }

      @Test
      public void testMockitoDoGet() throws Exception
      {
          // Vue attendue
          final String vue = "/WEB-INF/views/inscription.jsp";
          // Pour forward
          final ServletContext servletContext = mock(ServletContext.class);
          final RequestDispatcher dispatcher = new RequestDispatcher() {

              @Override
              public void forward(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
                  // Set la vue attendue dans le dispatcher de test
                  servletRequest.getServletContext().getRequestDispatcher(vue);
              }

              @Override
              public void include(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

              }
          };

          when(mockitoRequest.getServletContext()).thenReturn(servletContext);
          when(mockitoRequest.getServletContext().getRequestDispatcher("/WEB-INF/views/inscription.jsp")).thenReturn(dispatcher);

          inscriptionServlet.doGet(mockitoRequest, mockitoResponse);

          // Vérifier le dispatcher = un  aiguilleur
          assertEquals(dispatcher, mockitoRequest.getServletContext().getRequestDispatcher(vue) );
      }

	  @Test
	  public void testMockitoDoPost() throws Exception
	  {
          // Données du formulaire
		  when(mockitoRequest.getParameter("login")).thenReturn("me");
	      when(mockitoRequest.getParameter("email")).thenReturn("testemail@gmail.com");
	      when(mockitoRequest.getParameter("conditionsGeneralesApprouvees")).thenReturn("true");

          // Vue attendue
          final String vue = "/WEB-INF/views/inscriptionOk.jsp";
          // Pour forward
          final ServletContext servletContext = mock(ServletContext.class);
          final RequestDispatcher dispatcher = new RequestDispatcher() {

              @Override
              public void forward(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
                  // Set la vue attendue dans le dispatcher de test
                  servletRequest.getServletContext().getRequestDispatcher(vue);
              }

              @Override
              public void include(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

              }
          };

          when(mockitoRequest.getServletContext()).thenReturn(servletContext);
          when(mockitoRequest.getServletContext().getRequestDispatcher(vue)).thenReturn(dispatcher);

	      inscriptionServlet.doPost(mockitoRequest, mockitoResponse);

          // Vérifier les données passées
          assertEquals("me", mockitoRequest.getParameter("login"));
          assertEquals("testemail@gmail.com", mockitoRequest.getParameter("email"));
          assertEquals("true", mockitoRequest.getParameter("conditionsGeneralesApprouvees"));

          // Vérifier le dispatcher = un  aiguilleur
          assertEquals(dispatcher, mockitoRequest.getServletContext().getRequestDispatcher(vue) );
	  }
}
