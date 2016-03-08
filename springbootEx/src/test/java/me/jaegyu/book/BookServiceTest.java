package me.jaegyu.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookApplication.class)
public class BookServiceTest {

	@Autowired
	private BookService service;

	@Test
	public void getBooks() {

		BookDto.Create createDto = new BookDto.Create();
		createDto.setName("Thinking in java");
		createDto.setAuthor("Bruce Eckel");
		createDto.setPrice(43000l);

		service.createBook(createDto);

		createDto.clear();
		createDto.setName("자바의 정석");
		createDto.setAuthor("남궁성");
		createDto.setPrice(25000l);
		service.createBook(createDto);

		System.out.println(service.getBooks());
	}
	
	@Test
	public void getBooksToPage(){
		BookDto.Create createDto = new BookDto.Create();
		createDto.setName("Thinking in java");
		createDto.setAuthor("Bruce Eckel");
		createDto.setPrice(43000l);
		service.createBook(createDto);

		createDto.clear();
		createDto.setName("자바의 정석");
		createDto.setAuthor("남궁성");
		createDto.setPrice(25000l);
		service.createBook(createDto);
		
		createDto.clear();
		createDto.setName("자바의 정석2");
		createDto.setAuthor("남궁성");
		createDto.setPrice(25000l);
		service.createBook(createDto);
		
		createDto.clear();
		createDto.setName("자바의 정석3");
		createDto.setAuthor("남궁성");
		createDto.setPrice(25000l);
		service.createBook(createDto);
		
		createDto.clear();
		createDto.setName("Spring4");
		createDto.setAuthor("최범균");
		createDto.setPrice(28000l);
		service.createBook(createDto);
		
		Page<Book> booksToPage = service.getBooksToPage(new PageRequest(1, 2));

		System.out.println(booksToPage.getContent());
	}

}
