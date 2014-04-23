package fr.epsi.mvc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

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
	  public void testMockitoDoPost() throws Exception
	  {
		  //TODO
	  }
}
