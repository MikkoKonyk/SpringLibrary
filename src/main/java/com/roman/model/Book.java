package com.roman.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Book {
	
	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer bookId;
	@Column 
	private String bookName;
	@Column 
	private String edition;
	@Column 
	private Integer year;
	@Column 
	private Integer pages;
	@Column 
	private Integer numberOfCopies;
	
	@ManyToMany( cascade=CascadeType.ALL)//, fetch= FetchType.EAGER)
	private List <Autor> autors = new ArrayList<Autor>();
	
	@OneToMany(cascade=CascadeType.ALL)//, fetch = FetchType.EAGER)
	private Collection<Storage> copies = new ArrayList<Storage>();
	
	public Book () {}
	
	
	public List<Autor> getAutors() {
		return autors;
	}

	public void setAutors(List<Autor> autors) {
		this.autors = autors;
	}
	
	public Collection<Storage> getCopies() {
		return copies;
	}

	public void setCopies(Collection<Storage> copies) {
		this.copies = copies;
	}

	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(Integer numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", edition=" + edition + ", year=" + year + ", pages="
				+ pages + ", numberOfCopies=" + numberOfCopies + ", autors="
				+ autors + ", copies=" + copies + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autors == null) ? 0 : autors.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((copies == null) ? 0 : copies.hashCode());
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result
				+ ((numberOfCopies == null) ? 0 : numberOfCopies.hashCode());
		result = prime * result + ((pages == null) ? 0 : pages.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (autors == null) {
			if (other.autors != null)
				return false;
		} else if (!autors.equals(other.autors))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (copies == null) {
			if (other.copies != null)
				return false;
		} else if (!copies.equals(other.copies))
			return false;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (numberOfCopies == null) {
			if (other.numberOfCopies != null)
				return false;
		} else if (!numberOfCopies.equals(other.numberOfCopies))
			return false;
		if (pages == null) {
			if (other.pages != null)
				return false;
		} else if (!pages.equals(other.pages))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	
}
