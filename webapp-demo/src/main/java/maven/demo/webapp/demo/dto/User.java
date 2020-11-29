package maven.demo.webapp.demo.dto;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String fullname;

	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Article> articles;

	public User() {
		super();
	}

	public User(Integer id, String fullname, String email, String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
	}

	public User(String fullname, String email, String password) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password + "]";
	}
}
