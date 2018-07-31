package info.dawidfilip.dto;

import java.io.Serializable;

public class SensorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean accelerometer;
	private boolean ambientTemperature;
	private boolean magneticField;
	private boolean gyroscope;
	
	public SensorDTO(){
	}
	
	public SensorDTO(boolean accelerometer, boolean ambientTemperature, boolean magneticField, boolean gyroscope) {
		this.accelerometer = accelerometer;
		this.ambientTemperature = ambientTemperature;
		this.magneticField = magneticField;
		this.gyroscope = gyroscope;
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
		return "Sensor [accelerometer=" + accelerometer + ", ambientTemperature=" + ambientTemperature
				+ ", magneticField=" + magneticField + ", gyroscope=" + gyroscope + "]";
	}
	
}
