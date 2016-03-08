package me.jaegyu.book;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

public class BookDto {

	@Data
	public static class Create {
		@NotBlank
		@Size(min = 5)
		private String name;

		@NotBlank
		@Size(min = 5)
		private String author;

		private Long price;
		
		public void clear(){
			this.name = null;
			this.author = null;
			this.price = 0l;
		}
	}

	@Data
	public static class Response {

		private Long id;
		private String name;
		private String author;
		private Long price;
		private Date updated;
	}

}
