package info.dawidfilip.dto;

import java.io.Serializable;

public class PhoneDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String brand;
	private String model;
	private String alias;

	private short batery;
	private short internalMemory;
	private short ram;

	private SensorDTO sensor;

	private CameraDTO cameraFront;
	private CameraDTO cameraBack;

	public PhoneDTO(){
	}

	public PhoneDTO(String brand, String model, String alias, short batery, short internalMemory, short ram, SensorDTO sensor,
			CameraDTO cameraFront, CameraDTO cameraBack) {
		super();
		this.brand = brand;
		this.model = model;
		this.alias = alias;
		this.batery = batery;
		this.internalMemory = internalMemory;
		this.ram = ram;
		this.sensor = sensor;
		this.cameraFront = cameraFront;
		this.cameraBack = cameraBack;
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

	public SensorDTO getSensor() {
		return sensor;
	}

	public void setSensor(SensorDTO sensor) {
		this.sensor = sensor;
	}

	public CameraDTO getCameraFront() {
		return cameraFront;
	}

	public void setCameraFront(CameraDTO cameraFront) {
		this.cameraFront = cameraFront;
	}

	public CameraDTO getCameraBack() {
		return cameraBack;
	}

	public void setCameraBack(CameraDTO cameraBack) {
		this.cameraBack = cameraBack;
	}

	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", model=" + model + ", alias=" + alias + ", batery=" + batery
				+ ", internalMemory=" + internalMemory + ", ram=" + ram + ", sensor=" + sensor + ", cameraFront="
				+ cameraFront + ", cameraBack=" + cameraBack + "]";
	}

}
