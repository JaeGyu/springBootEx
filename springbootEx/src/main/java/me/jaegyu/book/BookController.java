package me.jaegyu.book;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.undertow.attribute.RequestMethodAttribute;

@RestController
public class BookController {

	@Autowired
	private BookService service;

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public ResponseEntity<Object> createBook(@RequestBody @Valid BookDto.Create create, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Book newBook = service.createBook(create);

		return new ResponseEntity<Object>(newBook, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<Object> getBooks() {

		List<Book> books = service.getBooks();

		return new ResponseEntity<Object>(books, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}

}
