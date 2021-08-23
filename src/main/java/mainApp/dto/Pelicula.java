package mainApp.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="peliculas") //no deberia ser necesario
public class Pelicula {
	
	//Atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="calificacion_edad")
	private int calificacionEdad;
	
	@OneToMany()
	@JoinColumn(name="id")
	private List<Sala> sala;
	
	//Constructor
	public Pelicula () {
		
	}
	
	public Pelicula(Long id, String nombre, int calificacionEdad) {
		this.id = id;
		this.nombre = nombre;
		this.calificacionEdad = calificacionEdad;
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

	public int getCalificacionEdad() {
		return calificacionEdad;
	}

	public void setCalificacionEdad(int calificacionEdad) {
		this.calificacionEdad = calificacionEdad;
	}

	public void setSala(List<Sala> sala) {
		this.sala = sala;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
	public List<Sala> getSala() {
		return sala;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", calificacionEdad=" + calificacionEdad + "]";
	}
	
	
}
