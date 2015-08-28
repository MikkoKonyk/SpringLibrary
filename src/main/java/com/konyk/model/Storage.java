package com.konyk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Storage {

	@Id
	@Column 
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer copyId;
	@Column
	private String available;
	@Column 
	private Integer dateTaken;
	@Column 
	private Integer dateToReturn;
	
	@ManyToOne
	private Book book;
	
	@ManyToOne
	private Reader reader;

	public Storage (){}
	
	public Integer getCopyId() {
		return copyId;
	}

	public void setCopyId(Integer copyId) {
		this.copyId = copyId;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public Integer getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(Integer dateTaken) {
		this.dateTaken = dateTaken;
	}

	public Integer getDateToReturn() {
		return dateToReturn;
	}

	public void setDateToReturn(Integer dateToReturn) {
		this.dateToReturn = dateToReturn;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	@Override
	public String toString() {
		return "Storage [copyId=" + copyId + ", available=" + available
				+ ", dateTaken=" + dateTaken + ", dateToReturn=" + dateToReturn
				+ ", book=" + book + ", reader=" + reader + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((available == null) ? 0 : available.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((copyId == null) ? 0 : copyId.hashCode());
		result = prime * result
				+ ((dateTaken == null) ? 0 : dateTaken.hashCode());
		result = prime * result
				+ ((dateToReturn == null) ? 0 : dateToReturn.hashCode());
		result = prime * result + ((reader == null) ? 0 : reader.hashCode());
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
		Storage other = (Storage) obj;
		if (available == null) {
			if (other.available != null)
				return false;
		} else if (!available.equals(other.available))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (copyId == null) {
			if (other.copyId != null)
				return false;
		} else if (!copyId.equals(other.copyId))
			return false;
		if (dateTaken == null) {
			if (other.dateTaken != null)
				return false;
		} else if (!dateTaken.equals(other.dateTaken))
			return false;
		if (dateToReturn == null) {
			if (other.dateToReturn != null)
				return false;
		} else if (!dateToReturn.equals(other.dateToReturn))
			return false;
		if (reader == null) {
			if (other.reader != null)
				return false;
		} else if (!reader.equals(other.reader))
			return false;
		return true;
	}

}
