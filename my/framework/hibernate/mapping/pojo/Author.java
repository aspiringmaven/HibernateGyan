package my.framework.hibernate.mapping.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Author {
	public Author(int authorId, String name, List<Book> book) {
		super();
		this.authorId = authorId;
		this.name = name;
		this.book = book;
	}

	@GenericGenerator(name="authori_generator" , strategy="increment")
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="authori_generator")
	private int authorId;
	private String name;
	@ManyToMany(mappedBy="author", cascade= CascadeType.ALL)
	private List<Book> book;

	/**
	 * 
	 * @param authorId
	 * @param name
	 */
	public Author(int authorId, String name) {
		super();
//		this.authorId = authorId;
		this.name = name;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void ListAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void ListName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + "]";
	}

	/**
	 * @return the book
	 */
	public List<Book> getBook() {
		return book;
	}

	/**
	 * @param book
	 *            the book to List
	 */
	public void ListBook(List<Book> book) {
		this.book = book;
	}

}
