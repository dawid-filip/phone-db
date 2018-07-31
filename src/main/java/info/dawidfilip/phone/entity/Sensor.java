package info.dawidfilip.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import info.dawidfilip.dto.SensorDTO;

@Entity
@Table(name = "Sensor")
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "Accelerometer")
	private boolean accelerometer;
	@Column(name = "AmbientTemperature")
	private boolean ambientTemperature;
	@Column(name = "MagneticField")
	private boolean magneticField;
	@Column(name = "Gyroscope")
	private boolean gyroscope;
	
	public Sensor(){
	}
	
	public Sensor(long id, boolean accelerometer, boolean ambientTemperature, boolean magneticField,
			boolean gyroscope) {
		this.id = id;
		this.accelerometer = accelerometer;
		this.ambientTemperature = ambientTemperature;
		this.magneticField = magneticField;
		this.gyroscope = gyroscope;
	}
	
	public Sensor(boolean accelerometer, boolean ambientTemperature, boolean magneticField, boolean gyroscope) {
		this.accelerometer = accelerometer;
		this.ambientTemperature = ambientTemperature;
		this.magneticField = magneticField;
		this.gyroscope = gyroscope;
	}
	
	public Sensor(SensorDTO sensorDTO) {
		this(
			sensorDTO.isAccelerometer(),
			sensorDTO.isAmbientTemperature(),
			sensorDTO.isMagneticField(),
			sensorDTO.isGyroscope()
		);
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

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", accelerometer=" + accelerometer + ", ambientTemperature=" + ambientTemperature
				+ ", magneticField=" + magneticField + ", gyroscope=" + gyroscope + "]";
	}

	
}
