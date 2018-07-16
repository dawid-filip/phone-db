package org.dawidfilip.phone.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
public class PhoneTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "BrandOfPhone", nullable = false, length = 100)
	private String brand;
	
	@Column(name = "MoodelOfPhone", columnDefinition = "VARCHAR(100) NOT NULL")
	private String model;
	
	@Column(name = "PriceOfPhone")
	private double price;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal premierePrice;
	

	public PhoneTest(){
	}
	
	public PhoneTest(long id, String brand, String model, double price, BigDecimal premierePrice) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.premierePrice = premierePrice;
	}
	public PhoneTest(String brand, String model, double price, BigDecimal premierePrice) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.premierePrice = premierePrice;
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
	public BigDecimal getPremierePrice() {
		return premierePrice;
	}
	public void setPremierePrice(BigDecimal premierePrice) {
		this.premierePrice = premierePrice;
	}

	@Override
	public String toString() {
		return "PhoneTest [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + ", premierePrice="
				+ premierePrice + "]";
	}

	
}
