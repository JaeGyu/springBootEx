package me.jaegyu.book;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BookTest {

	@Test
	public void getterSetter() {
		Book book = new Book();
		book.setName("빠르게 활용하는 파이썬 3.2 프로그램");
		book.setPrice(32000l);
		book.setAuthor("신호철,우상정");

		assertThat(book.getPrice(), is(32000l));
		assertThat(book.getName(), is("빠르게 활용하는 파이썬 3.2 프로그램"));
	}
}
