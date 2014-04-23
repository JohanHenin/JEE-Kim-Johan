package fr.epsi.mvc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
		  //TODO : problème à cause foward
		  //final ServletConfig servletConfig = mock(ServletConfig.class);
	      //final ServletContext servletContext = mock(ServletContext.class);
	      //when(servletConfig.getServletContext()).thenReturn(servletContext);
	      //inscriptionServlet.init(servletConfig);
		  final ServletContext servletContext = mock(ServletContext.class);
		  when(mockitoRequest.getServletContext()).thenReturn(servletContext);
	      
		  when(mockitoRequest.getParameter("login")).thenReturn("me");
	      when(mockitoRequest.getParameter("email")).thenReturn("testemail@gmail.com");
	      when(mockitoRequest.getParameter("conditionsGeneralesApprouvees")).thenReturn("true");
	      
	      inscriptionServlet.doPost(mockitoRequest, mockitoResponse);
		  
		  verify(mockitoRequest, atLeast(1)).getParameter("login");
		  verify(mockitoRequest, atLeast(1)).getParameter("email");
		  verify(mockitoRequest, atLeast(1)).getParameter("conditionsGeneralesApprouvees");
	  }
}
