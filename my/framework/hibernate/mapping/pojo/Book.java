package my.framework.hibernate.mapping.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Book {
	@GenericGenerator(name="booki_generator", strategy="increment")
	@Id @GeneratedValue(strategy=GenerationType.AUTO,generator="booki_generator")
	private int bookId;
	private String title;

	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(
			name="Book_Author_Juntion",
			joinColumns = {
					@JoinColumn(name="bookID_FK", referencedColumnName="bookID")
			},
			inverseJoinColumns = {
					@JoinColumn(name="authorId_FK", referencedColumnName="authorId")
			}	
	)
	private List<Author> author;

	public Book(int bookId, String title, List<Author> author) {
		super();
//		this.bookId = bookId;
		this.title = title;
		this.ListAuthor(author);
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + getAuthor() + "]";
	}

	public int getBookId() {
		return bookId;
	}

	public void ListBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void ListTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public List<Author> getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to List
	 */
	public void ListAuthor(List<Author> author) {
		this.author = author;
	}

}
