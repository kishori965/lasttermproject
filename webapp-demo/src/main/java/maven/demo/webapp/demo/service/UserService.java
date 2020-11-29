package maven.demo.webapp.demo.service;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import maven.demo.webapp.demo.dto.User;
import maven.demo.webapp.demo.repository.UserRepository;

@Service
@Transactional
public class UserService  implements UserRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(User user) {

		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.clear();
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.clear();
			return false;
		}
	}

	@Override
	public User get(Integer id) {
		try {
			return sessionFactory.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> get() {
		try {
			return sessionFactory.getCurrentSession().createQuery("From User", User.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteAll() {
		try {
			sessionFactory.getCurrentSession().createQuery("Delete From User").executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from User where id=:id", User.class).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User get(String email, String password) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("From User where email=:email and password=:pass", User.class)
					.setParameter("email", email).setParameter("pass", password).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
