package my.framework.hibernate.mapping.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EBook {

	@Id
	@GeneratedValue
	private int id;
	private String bookTitle;
	private String bookISBN;
	private String Author;
	@Enumerated(value=EnumType.STRING)
	private Discipline discipline;
	@Temporal(value=TemporalType.DATE)
	private Date publishingYear;
	private int cost;

	public EBook() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}
	
	@Override
	public String toString() {		
		return "Title :: "+this.getBookTitle() +" Discipline :: "+getDiscipline()+" Author "+getAuthor()+" YEAR :: "+getPublishingYear()+" ISBN :: "+this.getBookISBN();
	}

	public Date getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(Date publishingYear) {
		this.publishingYear = publishingYear;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
