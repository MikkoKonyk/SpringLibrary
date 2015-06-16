package com.roman.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reader {

	@Id
	@Column 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer readerId;
	@Column 
	private String readerName;
	@Column 
	private String readerSurname;
	@Column 
	private String readerFatherName;
	@Column 
	private String readerAddress;
	@Column 
	private Integer readerPhone;
	@Column 
	private Integer readerBirthDate;
	
	@OneToMany(mappedBy = "reader", fetch = FetchType.EAGER)
	private List <Storage> storage = new ArrayList<Storage>() ;
	
	public Integer getReaderId() {
		return readerId;
	}

	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderSurname() {
		return readerSurname;
	}

	public void setReaderSurname(String readerSurname) {
		this.readerSurname = readerSurname;
	}

	public String getReaderFatherName() {
		return readerFatherName;
	}

	public void setReaderFatherName(String readerFatherName) {
		this.readerFatherName = readerFatherName;
	}

	public String getReaderAddress() {
		return readerAddress;
	}

	public void setReaderAddress(String readerAddress) {
		this.readerAddress = readerAddress;
	}

	public Integer getReaderPhone() {
		return readerPhone;
	}

	public void setReaderPhone(Integer readerPhone) {
		this.readerPhone = readerPhone;
	}

	public Integer getReaderBirthDate() {
		return readerBirthDate;
	}

	public void setReaderBirthDate(Integer readerBirthDate) {
		this.readerBirthDate = readerBirthDate;
	}

	public List<Storage> getStorage() {
		return storage;
	}

	public void setStorage(List<Storage> storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", readerName=" + readerName
				+ ", readerSurname=" + readerSurname + ", readerFatherName="
				+ readerFatherName + ", readerAddress=" + readerAddress
				+ ", readerPhone=" + readerPhone + ", readerBirthDate="
				+ readerBirthDate + ", storage=" + storage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((readerAddress == null) ? 0 : readerAddress.hashCode());
		result = prime * result
				+ ((readerBirthDate == null) ? 0 : readerBirthDate.hashCode());
		result = prime
				* result
				+ ((readerFatherName == null) ? 0 : readerFatherName.hashCode());
		result = prime * result
				+ ((readerId == null) ? 0 : readerId.hashCode());
		result = prime * result
				+ ((readerName == null) ? 0 : readerName.hashCode());
		result = prime * result
				+ ((readerPhone == null) ? 0 : readerPhone.hashCode());
		result = prime * result
				+ ((readerSurname == null) ? 0 : readerSurname.hashCode());
		result = prime * result + ((storage == null) ? 0 : storage.hashCode());
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
		Reader other = (Reader) obj;
		if (readerAddress == null) {
			if (other.readerAddress != null)
				return false;
		} else if (!readerAddress.equals(other.readerAddress))
			return false;
		if (readerBirthDate == null) {
			if (other.readerBirthDate != null)
				return false;
		} else if (!readerBirthDate.equals(other.readerBirthDate))
			return false;
		if (readerFatherName == null) {
			if (other.readerFatherName != null)
				return false;
		} else if (!readerFatherName.equals(other.readerFatherName))
			return false;
		if (readerId == null) {
			if (other.readerId != null)
				return false;
		} else if (!readerId.equals(other.readerId))
			return false;
		if (readerName == null) {
			if (other.readerName != null)
				return false;
		} else if (!readerName.equals(other.readerName))
			return false;
		if (readerPhone == null) {
			if (other.readerPhone != null)
				return false;
		} else if (!readerPhone.equals(other.readerPhone))
			return false;
		if (readerSurname == null) {
			if (other.readerSurname != null)
				return false;
		} else if (!readerSurname.equals(other.readerSurname))
			return false;
		if (storage == null) {
			if (other.storage != null)
				return false;
		} else if (!storage.equals(other.storage))
			return false;
		return true;
	}

}
