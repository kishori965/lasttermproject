package maven.demo.webapp.demo.service;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import maven.demo.webapp.demo.dto.Article;
import maven.demo.webapp.demo.repository.ArticleRepository;




@Service
@Transactional
public class ArticleService  implements ArticleRepository  {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Article article) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(article);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.clear();
		}
		return false;
	}

	@Override
	public boolean update(Article article) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(article);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.clear();
		}
		return false;
	}

	@Override
	public boolean delete(Article article) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(article);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.clear();
		}
		return false;
	}

	@Override
	public Article get(Integer id) {
		return sessionFactory.getCurrentSession().get(Article.class, id);
	}

	@Override
	public List<Article> get() {
		return sessionFactory.getCurrentSession().createQuery("From Article", Article.class).getResultList();
	}

	@Override
	public List<Article> getByUserId(Integer userId) {
		return sessionFactory.getCurrentSession().createQuery("From Article where userid=:id", Article.class)
				.getResultList();
	}

	@Override
	public boolean deleteAll() {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from Article");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
