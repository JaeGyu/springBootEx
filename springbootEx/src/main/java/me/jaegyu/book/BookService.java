package me.jaegyu.book;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import me.jaegyu.book.BookDto.Create;

@Service
@Transactional
public class BookService {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private PagingAndSortingRepository<Book, Long> pRepository;

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
	
	public Page<Book> getBooksToPage(Pageable pageable){
		return pRepository.findAll(pageable);
	}
}
