package com.roman.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Autor {
	
	@Id
	@Column 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer autorId;
	@Column
	private String name;
	@Column 
	private String surname;
	
	@ManyToMany(cascade=CascadeType.ALL)//, fetch = FetchType.EAGER)
	private List <Book> books = new ArrayList<Book>() ;
	
	public Autor() {}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Autor [autorId=" + autorId + ", name=" + name + ", surname="
				+ surname + ", books=" + books + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autorId == null) ? 0 : autorId.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Autor other = (Autor) obj;
		if (autorId == null) {
			if (other.autorId != null)
				return false;
		} else if (!autorId.equals(other.autorId))
			return false;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
}
