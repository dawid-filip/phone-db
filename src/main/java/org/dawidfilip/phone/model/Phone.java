package org.dawidfilip.phone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "Phone")
@NamedQueries({ 
	@NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p") 
})
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "BRAND", nullable = false, length = 100)
	private String brand;

	@Column(name = "MODEL", columnDefinition = "VARCHAR(100) NOT NULL")
	private String model;

	@Column(name = "PRICE")
	private double price;

	public Phone() {
	}

	public Phone(String brand, String model, double price) {
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getPrice() {
		return price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + "]";
	}

}
