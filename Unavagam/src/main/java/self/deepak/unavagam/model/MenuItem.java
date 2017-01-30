package self.deepak.unavagam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="MENU_ITEM")
public class MenuItem {
	
	@Id
	@NotEmpty(message="Product ID cannot be Empty !")
	@Column(name="ID")
	private String id; 
	
	@NotEmpty(message="Productname cannot be Empty  !")
	@Column(name="NAME")
	private String name;
	
	@Min(value=100,message="Minimum Price must be 100   !")		
	@NotNull(message="Price must be positive & cannot be null   !")
	@Column(name="PRICE")
	private Integer price ;
	
/*	@NotEmpty(message="Product description cannot be Empty  !")
	@Column(name="DESCRIPTION")
	private String description;
*/
	/*
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categoryname")
	private CategoryDetails category;
	*/
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + "]";
	}



}
