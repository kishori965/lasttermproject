package maven.demo.webapp.demo.util;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import maven.demo.webapp.demo.dto.User;

@Component

public class UserValidation {
	public Map<String, String> validate(User user) {
		Map<String, String> errorMessages = new HashMap<String, String>();
		if (user.getFullname().isBlank()) {
			errorMessages.put("fullnameError", "Enter the fullname");
		}

		if (user.getEmail().isBlank()) {
			errorMessages.put("emailError", "Enter the email");
		}

		if (user.getPassword().isBlank()) {
			errorMessages.put("passwordError", "Enter the password");
		}

		return errorMessages;
	}
}
