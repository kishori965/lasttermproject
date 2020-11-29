package maven.demo.webapp.demo.controller;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import maven.demo.webapp.demo.dto.Article;
import maven.demo.webapp.demo.dto.User;
import maven.demo.webapp.demo.repository.ArticleRepository;

@Controller
@RequestMapping("/user")

public class ArticleController {
	@Autowired
	private ArticleRepository articleRepository;

	// /user/addarticle
	@PostMapping("/addarticle")
	public String addArticle(@ModelAttribute("article") Article article, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		article.setUser(user);
		article.setPostedDate(new Date());
		if (articleRepository.save(article)) {
			return "redirect:/user/articles";
		}

		model.addAttribute("errorMessage", "Internal Error Occured.");
		return "addarticle";
	}

	// /user/articles
	@GetMapping("/articles")
	public void getArticles() {

	}

	@GetMapping("/article/{id}")
	public void getSpecificAritcle() {

	}

	@GetMapping("/myarticles")
	public void getUserArticles() {

	}

}
