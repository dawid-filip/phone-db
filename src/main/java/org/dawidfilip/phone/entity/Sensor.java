package org.dawidfilip.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sensor")
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	private boolean accelerometer;
	private boolean ambientTemperature;
	private boolean magneticField;
	private boolean gyroscope;
	
	public Sensor(){
	}
	
	public Sensor(boolean accelerometer, boolean ambientTemperature, boolean magneticField, boolean gyroscope) {
		this.accelerometer = accelerometer;
		this.ambientTemperature = ambientTemperature;
		this.magneticField = magneticField;
		this.gyroscope = gyroscope;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAccelerometer() {
		return accelerometer;
	}

	public void setAccelerometer(boolean accelerometer) {
		this.accelerometer = accelerometer;
	}

	public boolean isAmbientTemperature() {
		return ambientTemperature;
	}

	public void setAmbientTemperature(boolean ambientTemperature) {
		this.ambientTemperature = ambientTemperature;
	}

	public boolean isMagneticField() {
		return magneticField;
	}

	public void setMagneticField(boolean magneticField) {
		this.magneticField = magneticField;
	}

	public boolean isGyroscope() {
		return gyroscope;
	}

	public void setGyroscope(boolean gyroscope) {
		this.gyroscope = gyroscope;
	}

}