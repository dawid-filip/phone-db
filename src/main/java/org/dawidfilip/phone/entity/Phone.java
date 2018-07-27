package org.dawidfilip.phone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "Phone")
@NamedQueries({ 
	@NamedQuery(name = "Phone.find", query = "SELECT p FROM Phone p WHERE p.id = :id"),
	@NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p"),
	@NamedQuery(name = "Phone.delete", query = "DELETE FROM Phone p WHERE p.id = :id") 
})
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;

	@Column(name = "Brand", nullable = false, length = 85)
	private String brand;

	@Column(name = "Model", nullable = false, length = 85)
	private String model;

	@Column(name = "Alias", nullable = true)
	private String alias;

	private short batery;
	private short internalMemory;
	private short ram;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH })
	@JoinColumn(name = "sensorId")
	private Sensor sensor;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH })
	@JoinColumn(name = "cameraFrontId")
	private Camera cameraFront;

	public Phone(){
	}
	
	public Phone(String brand, String model, String alias, short batery, short internalMemory, short ram,
			Sensor sensor, Camera cameraFront) {
		this.brand = brand;
		this.model = model;
		this.alias = alias;
		this.batery = batery;
		this.internalMemory = internalMemory;
		this.ram = ram;
		this.sensor = sensor;
		this.cameraFront = cameraFront;
	}
	
	public Phone(long id, String brand, String model, String alias, short batery, short internalMemory, short ram,
			Sensor sensor, Camera cameraFront) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.alias = alias;
		this.batery = batery;
		this.internalMemory = internalMemory;
		this.ram = ram;
		this.sensor = sensor;
		this.cameraFront = cameraFront;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public short getBatery() {
		return batery;
	}

	public void setBatery(short batery) {
		this.batery = batery;
	}

	public short getInternalMemory() {
		return internalMemory;
	}

	public void setInternalMemory(short internalMemory) {
		this.internalMemory = internalMemory;
	}

	public short getRam() {
		return ram;
	}

	public void setRam(short ram) {
		this.ram = ram;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public Camera getCameraFront() {
		return cameraFront;
	}

	public void setCameraFront(Camera cameraFront) {
		this.cameraFront = cameraFront;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", brand=" + brand + ", model=" + model + ", alias=" + alias + ", batery=" + batery
				+ ", internalMemory=" + internalMemory + ", ram=" + ram + ", sensor=" + sensor + ", cameraFront="
				+ cameraFront + "]";
	}

}
