package me.jaegyu.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tbl_user")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User extends AbstractPersistable<Integer> {
	private String userName;
	private String nickName;
	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();

	public User(String userName, String nickName, String address, Date createDate) {
		super();
		this.userName = userName;
		this.nickName = nickName;
		this.address = address;
		this.createDate = createDate;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}

}
