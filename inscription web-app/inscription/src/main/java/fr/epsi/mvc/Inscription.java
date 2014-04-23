package fr.epsi.mvc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Inscription {

	private String login;
	private String email;
	private boolean conditionsGeneralesApprouvees;
	private Date creation;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreation() {
		return creation;
	}

	public boolean isConditionsGeneralesApprouvees() {
		return conditionsGeneralesApprouvees;
	}

	public void setConditionsGeneralesApprouvees(boolean conditionsGeneralesApprouvees) {
		this.conditionsGeneralesApprouvees = conditionsGeneralesApprouvees;
	}

	public void validate() throws InscriptionInvalideException {
		Map<String, String> errorMessages = new HashMap<>();

		if (!Objects.toString(login, "").matches("\\S+")) {
			errorMessages.put("login", "Le login n'est pas correctement renseigné !");
		}
		if (!Objects.toString(email, "").matches("\\S+@\\S+")) {
			errorMessages.put("email", "L'e-mail est invalide !");
		}
		if (!conditionsGeneralesApprouvees) {
			errorMessages.put("conditionsGeneralesApprouvees", "Vous devez approuver les conditions générales !");
		}

		if (!errorMessages.isEmpty()) {
			throw new InscriptionInvalideException(errorMessages);
		}

		this.creation = new Date();
	}

}
