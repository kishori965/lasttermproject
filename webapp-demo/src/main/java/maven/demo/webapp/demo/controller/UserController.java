package maven.demo.webapp.demo.controller;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import maven.demo.webapp.demo.dto.User;
import maven.demo.webapp.demo.repository.UserRepository;
import maven.demo.webapp.demo.util.UserValidation;

@Controller
public class UserController {
	@Autowired
	private UserValidation userValidation;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/signup")
	public String signup(@ModelAttribute("user") User user, Model model) {

		Map<String, String> errorMessages = userValidation.validate(user);
		if (!errorMessages.isEmpty()) {
			model.addAttribute("errorMessages", errorMessages);
			return "signup";
		}

		if (userRepository.save(user)) {
			return "redirect:/login";
		} else {
			model.addAttribute("errroMessage", "Internal Error Occured. Try again");
			return "signup";
		}

	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		User user = userRepository.get(email, password);
		if (user == null) {
			model.addAttribute("errorMessage", "Invalid Credentials");
			return "login";
		}
		session.setAttribute("user", user);
		return "redirect:/home";
	}

}
