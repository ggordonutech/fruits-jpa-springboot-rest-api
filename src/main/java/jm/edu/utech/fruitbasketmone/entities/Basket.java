package jm.edu.utech.fruitbasketmone.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="baskets")
public class Basket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="owner_name")
	@NotBlank
	private String ownerName;
	
	@Transient
	@OneToMany(cascade=CascadeType.ALL,mappedBy="basket")
	@JoinColumn(name="basket_id")
	private List<Fruit> fruits;
	
	

	public Basket() {
		super();
	}

	public Basket(String ownerName) {
		super();
		this.ownerName = ownerName;
	}

	public Basket(int id, String ownerName, List<Fruit> fruits) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.fruits = fruits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public List<Fruit> getFruits() {
		return fruits;
	}

	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", ownerName=" + ownerName + "]";
	}
	
	
	
	

}
