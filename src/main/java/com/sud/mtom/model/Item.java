package com.sud.mtom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_MM")
public class Item {

	@Id
	@Column(name="item_id")
	@GeneratedValue
	private long id;
	
	@Column(name="item_price")
	private double price;
	
	@Column(name="item_desc")
	private String description;
	
	/*
	 * @ManyToMany(mappedBy = "ITEM_MM", cascade = { CascadeType.ALL }) private
	 * Set<Cart1> carts = new HashSet();
	 * 
	 * public Set<Cart1> getCarts() { return carts; }
	 * 
	 * public void setCarts(Set<Cart1> carts) { this.carts = carts; }
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
