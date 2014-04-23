package fr.epsi.mvc;
import static org.junit.Assert.*;

import org.junit.*;

public class TestInscription 
{
	private Inscription signin;
	
	@Before
	public void initValideInscription()
	{
		signin = new Inscription();
		signin.setLogin("Toto");
		signin.setEmail("email@gmail.com");
		signin.setConditionsGeneralesApprouvees(true);
	}
	
	
	@Test
	public void canValidate() throws Exception 
	{
		signin.validate();
		assertNotNull(signin.getCreation());
	}
	
	@Test
	public void cannotValidateLogin() throws Exception 
	{
		signin.setLogin(null);
		
		try
		{
			signin.validate();
		}
		catch (InscriptionInvalideException e)
		{
			assertEquals("Le login n'est pas correctement renseigné !", e.getErrorMessages().get("login"));
		}		
	}
	
	@Test
	public void cannotValidateEmailNull() throws Exception 
	{
		signin.setEmail(null);
		
		try
		{
			signin.validate();
		}
		catch (InscriptionInvalideException e)
		{
			assertEquals("L'e-mail est invalide !", e.getErrorMessages().get("email"));
		}		
	}
	
	@Test
	public void cannotValidateEmailRegex() throws Exception 
	{
		signin.setEmail("adresseEmail");
		
		try
		{
			signin.validate();
		}
		catch (InscriptionInvalideException e)
		{
			assertEquals("L'e-mail est invalide !", e.getErrorMessages().get("email"));
		}		
	}
	
	@Test
	public void cannotValidateConditionsGeneralesApprouvees() throws Exception 
	{
		signin.setConditionsGeneralesApprouvees(false);
		
		try
		{
			signin.validate();
		}
		catch (InscriptionInvalideException e)
		{
			assertEquals("Vous devez approuver les conditions générales !", e.getErrorMessages().get("conditionsGeneralesApprouvees"));
		}		
	}

}
