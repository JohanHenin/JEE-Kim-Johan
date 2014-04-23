package fr.epsi.mvc;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class TestInscriptionServletMockito 
{
	HttpServletRequest request;
	HttpServletResponse response;
	
	InscriptionServlet inscriptionServlet;
	
	@Before
	public void setUp() throws Exception
	{
		request = mock(HttpServletRequest.class); 
		response = mock(HttpServletResponse.class);
		
		inscriptionServlet = new InscriptionServlet();
	}
	
	 @Test
	  public void testDemoMockito() throws Exception 
	  {
	        when(request.getParameter("login")).thenReturn("me");
	        when(request.getParameter("email")).thenReturn("testemail@gmail.com");
	        when(request.getParameter("conditionsGeneralesApprouvees")).thenReturn("true");

	        inscriptionServlet.doPost(request, response);

	        assertNotNull(request.getAttribute("inscription"));
	  }
}
