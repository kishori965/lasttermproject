package maven.demo.webapp.demo.dto;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, unique = true)
	private String title;
	@Column(nullable = false)
	private String content;
	@Column(nullable = false)
	private Date postedDate;

	@ManyToOne(cascade = CascadeType.REMOVE)
	private User user;

	public Article() {
		super();
	}

	public Article(Integer id, String title, String content, Date postedDate, User user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.postedDate = postedDate;
		this.user = user;
	}

	public Article(String title, String content, Date postedDate, User user) {
		super();
		this.title = title;
		this.content = content;
		this.postedDate = postedDate;
		this.user = user;
	}

	public Article(String title, String content, Date postedDate) {
		super();
		this.title = title;
		this.content = content;
		this.postedDate = postedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", postedDate=" + postedDate + "]";
	}
}
