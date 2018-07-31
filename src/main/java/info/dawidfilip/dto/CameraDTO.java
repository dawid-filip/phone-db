package info.dawidfilip.dto;

import java.io.Serializable;

public class CameraDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String model;
	private String matrix;
	private String resolution;

	public CameraDTO() {
	}
	
	public CameraDTO(long id, String model, String matrix, String resolution) {
		super();
		this.model = model;
		this.matrix = matrix;
		this.resolution = resolution;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMatrix() {
		return matrix;
	}

	public void setMatrix(String matrix) {
		this.matrix = matrix;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		return "CameraDTO [model=" + model + ", matrix=" + matrix + ", resolution=" + resolution + "]";
	}

}
