package fr.epsi.mvc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import static org.mockito.Mockito.*;


public class TestInscriptionServletMockito {
	 @Test
	  public void testDemoMockito() throws Exception {
		    HttpServletRequest request = mock(HttpServletRequest.class);       
	        HttpServletResponse response = mock(HttpServletResponse.class);    

	        when(request.getParameter("login")).thenReturn("me");
	        when(request.getParameter("email")).thenReturn("aaaa@aaa.aaa");
	        when(request.getParameter("conditionsGeneralesApprouvees")).thenReturn("true");

	        new InscriptionServlet().doPost(request, response);

	        assertNotNull(request.getAttribute("inscription"));
	  }
}
