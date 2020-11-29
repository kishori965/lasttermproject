package maven.demo.webapp.demo.repository;

import java.util.List;

import maven.demo.webapp.demo.dto.Article;

public interface ArticleRepository {
	public boolean save(Article article);

	public boolean update(Article article);

	public boolean delete(Article article);

	public Article get(Integer id);

	public List<Article> get();

	public List<Article> getByUserId(Integer userId);
	
	public boolean deleteAll();
}
