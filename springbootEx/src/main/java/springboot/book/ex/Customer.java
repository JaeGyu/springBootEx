package springboot.book.ex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor //lombok이 디폴트 생성자를 자동으로 만들어 준다.
@AllArgsConstructor //lombok이 전체 필드를 인자로 받는 생성자를 만들어 준다.
public class Customer {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
}
