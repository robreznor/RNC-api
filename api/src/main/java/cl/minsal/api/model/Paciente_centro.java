package cl.minsal.api.model;

import java.io.Serializable;

import javax.persistence.Entity;


@Entity
public class Paciente_centro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private Integer id_paciente;	
	private Integer id_centro;
	
	
	public Integer getId_paciente() {
		return id_paciente;
	}
	
	public Integer getId_centro() {
		return id_centro;
	}
	
}
