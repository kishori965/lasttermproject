package maven.demo.webapp.demo.repository;

import java.util.List;

import maven.demo.webapp.demo.dto.User;

public interface UserRepository {
	public boolean save(User user);

	public boolean update(User user);

	public User get(Integer id);

	public List<User> get();

	public boolean deleteAll();

	public boolean delete(User user);

	public boolean delete(Integer id);
	
	public User get(String email, String password);

}
