package com.konyk.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.konyk.dao.AutorDao;
import com.konyk.dao.BookDao;
import com.konyk.dto.BookDto;
import com.konyk.model.Autor;
import com.konyk.model.Book;

@Service
public class BookDtoService {

	@Autowired
	AutorDao autorDao;

	@Autowired
	BookDao bookDao;

	@Autowired
	private SessionFactory session;

	@Transactional
	public void parseBookDto(BookDto bookDto) {

		Autor autor = new Autor();
		Book book = new Book();

		autor.setName(bookDto.getAutorNameDto());
		autor.setSurname(bookDto.getAutorSurnameDto());
		autorDao.add(autor);

		book.setBookId(bookDto.getBookIdDto());
		book.setBookName(bookDto.getBookNameDto());
		book.setEdition(bookDto.getBookEditionDto());
		book.setNumberOfCopies(bookDto.getBooknumberOfCoopies());
		book.setYear(bookDto.getBookYearDto());
		book.setPages(bookDto.getBookPagesDto());
		book.getAutors().add(autor);
		bookDao.add(book);

	}

	@Transactional
	public List<BookDto> getAll() {
		@SuppressWarnings("unchecked")
		List<Object[]> list = session
				.getCurrentSession()
				.createQuery(
						"select  b.bookId, b.bookName, b.edition, b.year, b.pages, b.numberOfCopies, ba.name, ba.surname, ba.autorId from Book b join b.autors ba ")
				.list();
		List<BookDto> dtoList = new ArrayList<BookDto>();
		System.out.println("In service running get all...");
		for (Object[] entry : list) {

			BookDto bookDto = new BookDto();
			bookDto.setBookIdDto((Integer) entry[0]);
			bookDto.setBookNameDto((String) entry[1]);
			bookDto.setBookEditionDto((String) entry[2]);
			bookDto.setBookYearDto((Integer) entry[3]);
			bookDto.setBookPagesDto((Integer) entry[4]);
			bookDto.setBooknumberOfCoopies((Integer) entry[5]);
			bookDto.setAutorNameDto((String) entry[6]);
			bookDto.setAutorSurnameDto((String) entry[7]);
			bookDto.setAutorIdDto((Integer) entry[8]);
			dtoList.add(bookDto);
		}
		return dtoList;
	}

	@Transactional
	public BookDto getBookDtoById(Integer id) {

		String queryString = "select  b.bookId, b.bookName, b.edition, b.year, b.pages, b.numberOfCopies, ba.name, ba.surname, ba.autorId"
				+ " from Book b join b.autors ba where b.bookId = :id";
		Query query = session.getCurrentSession().createQuery(queryString)
				.setInteger("id", id);

		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		BookDto bookDto = new BookDto();
		Object[] resultArr = list.get(0);
		bookDto.setBookIdDto((Integer) resultArr[0]);
		bookDto.setBookNameDto((String) resultArr[1]);
		bookDto.setBookEditionDto((String) resultArr[2]);
		bookDto.setBookYearDto((Integer) resultArr[3]);
		bookDto.setBookPagesDto((Integer) resultArr[4]);
		bookDto.setBooknumberOfCoopies((Integer) resultArr[5]);
		bookDto.setAutorNameDto((String) resultArr[6]);
		bookDto.setAutorSurnameDto((String) resultArr[7]);
		bookDto.setAutorIdDto((Integer) resultArr[8]);
		return bookDto;
	}

	@Transactional
	public void editBookDto(BookDto bookDto) {

		Autor autor = new Autor();
		Book book = new Book();

		autor.setAutorId(bookDto.getAutorIdDto());
		autor.setName(bookDto.getAutorNameDto());
		autor.setSurname(bookDto.getAutorSurnameDto());
		autorDao.update(autor);

		book.setBookId(bookDto.getBookIdDto());
		book.setBookName(bookDto.getBookNameDto());
		book.setEdition(bookDto.getBookEditionDto());
		book.setNumberOfCopies(bookDto.getBooknumberOfCoopies());
		book.setYear(bookDto.getBookYearDto());
		book.setPages(bookDto.getBookPagesDto());
		book.getAutors().add(autor);
		bookDao.update(book);
	}

	@Transactional
	public void deleteEntryDto(Integer id) {

		bookDao.delete(id);
	}

}
