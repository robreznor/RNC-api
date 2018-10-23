package cl.minsal.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Archivos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String nombre_archivo;
	private String tipo_mime;
	private Byte contenido;
	private Float tamaño;
	private String hash;
	
	@ManyToOne
    @JoinColumn(name="id_documento", nullable=false)
	private Documentos documentos;
	
	public Integer getId() {
		return id;
	}
	public String getNombre_archivo() {
		return nombre_archivo;
	}
	public String getTipo_mime() {
		return tipo_mime;
	}
	public Byte getContenido() {
		return contenido;
	}
	public Float getTamaañoo() {
		return tamaño;
	}
	public String getHash() {
		return hash;
	}
	
}
