package fr.epsi.mvc;

import java.util.Map;

public class InscriptionInvalideException extends Exception {

	private static final long serialVersionUID = -8592694936392880143L;
	private final Map<String, String> errorMessages;

	public InscriptionInvalideException(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
}
