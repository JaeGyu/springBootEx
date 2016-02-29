package me.jaegyu.account;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

	@Id
	@GeneratedValue
	private Long id;

	private String username;

	private String loginId;

	private String password;

	private String email;
	
	private String fullName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date joined;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
}
