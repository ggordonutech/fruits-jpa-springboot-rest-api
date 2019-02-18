package jm.edu.utech.fruitbasketmone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="fruits")
public class Fruit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private float price;
	
	@ManyToOne
	private Basket basket;
	
	
	
	public Fruit() {
		super();
	}
	public Fruit(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Fruit(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Fruit(int id, String name, float price, Basket basket) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.basket = basket;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", price=" + price  + "]";
	}
	
	

}
