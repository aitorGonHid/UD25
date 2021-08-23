package mainApp.dto;

import javax.persistence.*;

@Entity
@Table(name="salas") //no es necesario
public class Sala {
	
	//Atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="id_pelicula") //nombre de la columna que vincula
	private Pelicula pelicula;
	
	//Constructor
	public Sala() {
		
	}

	public Sala(Long id, String nombre, Pelicula pelicula) {
		this.id = id;
		this.nombre = nombre;
		this.pelicula = pelicula;
	}
	
	//Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombre=" + nombre + ", pelicula=" + pelicula + "]";
	}
	
}
