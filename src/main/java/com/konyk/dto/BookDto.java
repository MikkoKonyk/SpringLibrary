package com.konyk.dto;


public class BookDto {

	private Integer bookIdDto;
	private String bookNameDto;
	private String bookEditionDto;
	private Integer bookPagesDto;
	private Integer bookYearDto;
	private Integer booknumberOfCoopies;
	private Integer  autorIdDto;
	private String autorNameDto;
	private String autorSurnameDto;
	
	
	public Integer getBookIdDto() {
		return bookIdDto;
	}
	public void setBookIdDto(Integer bookIdDto) {
		this.bookIdDto = bookIdDto;
	}
	public String getBookNameDto() {
		return bookNameDto;
	}
	public void setBookNameDto(String bookNameDto) {
		this.bookNameDto = bookNameDto;
	}
	public String getBookEditionDto() {
		return bookEditionDto;
	}
	public void setBookEditionDto(String bookEditionDto) {
		this.bookEditionDto = bookEditionDto;
	}
	public Integer getBookPagesDto() {
		return bookPagesDto;
	}
	public void setBookPagesDto(Integer bookpagesDto) {
		this.bookPagesDto = bookpagesDto;
	}
	public Integer getBookYearDto() {
		return bookYearDto;
	}
	public void setBookYearDto(Integer bookYearDto) {
		this.bookYearDto = bookYearDto;
	}
	public Integer getBooknumberOfCoopies() {
		return booknumberOfCoopies;
	}
	public void setBooknumberOfCoopies(Integer booknumberOfCoopies) {
		this.booknumberOfCoopies = booknumberOfCoopies;
	}
	public String getAutorNameDto() {
		return autorNameDto;
	}
	public void setAutorNameDto(String autorNameDto) {
		this.autorNameDto = autorNameDto;
	}
	public String getAutorSurnameDto() {
		return autorSurnameDto;
	}
	public void setAutorSurnameDto(String autorSurnameDto) {
		this.autorSurnameDto = autorSurnameDto;
	}
	
	public Integer getAutorIdDto() {
		return autorIdDto;
	}
	public void setAutorIdDto(Integer autorIdDto) {
		this.autorIdDto = autorIdDto;
	}

	@Override
	public String toString() {
		return "BookDto [bookIdDto=" + bookIdDto + ", bookNameDto="
				+ bookNameDto + ", bookEditionDto=" + bookEditionDto
				+ ", bookPagesDto=" + bookPagesDto + ", bookYearDto="
				+ bookYearDto + ", booknumberOfCoopies=" + booknumberOfCoopies
				+ ", autorNameDto=" + autorNameDto + ", autorSurnameDto="
				+ autorSurnameDto + "]";
	}
}
