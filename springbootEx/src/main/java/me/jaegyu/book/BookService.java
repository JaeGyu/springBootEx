package me.jaegyu.book;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.jaegyu.book.BookDto.Create;

@Service
@Transactional
public class BookService {

	@Autowired
	private BookRepository repository;

	public Book createBook(Create dto) {

		Book book = new Book();
		book.setName(dto.getName());
		book.setAuthor(dto.getAuthor());
		book.setPrice(dto.getPrice());

		Date now = new Date();
		book.setUpdated(now);

		return repository.save(book);
	}
	
	public List<Book> getBooks(){
		return repository.findAll();
	}
}
