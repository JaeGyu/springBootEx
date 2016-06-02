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

@Entity(name = "tbl_user")
@NoArgsConstructor
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

	@Override
	public String toString() {
		return "User [userName=" + userName + ", nickName=" + nickName + ", address=" + address + ", createDate="
				+ createDate + ", orders=" + orders + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
