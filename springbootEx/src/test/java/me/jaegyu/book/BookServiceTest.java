package me.jaegyu.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
		createDto.setAuthor("bruku");
		createDto.setPrice(43000l);

		service.createBook(createDto);

		createDto.clear();
		createDto.setName("자바의 정석");
		createDto.setAuthor("남궁성");
		createDto.setPrice(25000l);
		service.createBook(createDto);

		System.out.println(service.getBooks());
	}

}
