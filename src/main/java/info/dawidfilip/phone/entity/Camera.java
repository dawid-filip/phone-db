package info.dawidfilip.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import info.dawidfilip.dto.CameraDTO;

@Entity
public class Camera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;
	
	@Column(name = "Model", nullable = false, length = 50)
	private String model;

	@Enumerated(EnumType.STRING)
	@Column(name = "Matrix", length = 10)
	private Matrix matrix;

	@Enumerated(EnumType.STRING)
	@Column(name = "Resolution", length = 25)
	private Resolution resolution;

	public Camera() {
	}
	
	public Camera(long id, String model, Matrix matrix, Resolution resolution) {
		super();
		this.id = id;
		this.model = model;
		this.matrix = matrix;
		this.resolution = resolution;
	}
	
	public Camera(String model, Matrix matrix, Resolution resolution) {
		super();
		this.model = model;
		this.matrix = matrix;
		this.resolution = resolution;
	}
	
	public Camera(String model, String matrix, String resolution) {
		super();
		this.model = model;
		this.matrix = Matrix.valueOf(Matrix.class, matrix.trim());
		this.resolution = Resolution.valueOf(Resolution.class, resolution.trim());
	}
	
	public Camera(Camera camera) {
		this(camera.getModel(),	camera.getMatrix(),	camera.getResolution());
	}
	
	public Camera(CameraDTO cameraDTO) {
		this(cameraDTO.getModel(), cameraDTO.getMatrix(), cameraDTO.getResolution());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		return "Camera [id=" + id + ", model=" + model + ", matrix=" + matrix + ", resolution=" + resolution + "]";
	}

}
