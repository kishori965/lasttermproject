package maven.demo.webapp.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import maven.demo.webapp.demo.dto.Article;
import maven.demo.webapp.demo.dto.User;

@Controller

public class PageController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/user/addarticle")
	public String addArticle(Model model) {
		model.addAttribute("article", new Article());
		return "addarticle";
	}

}
