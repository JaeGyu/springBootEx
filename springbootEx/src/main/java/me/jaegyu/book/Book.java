package me.jaegyu.book;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Book {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String author;

	private Long price;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
}
