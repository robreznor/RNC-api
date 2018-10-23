package cl.minsal.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Medico_centro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_medico;	
	private Integer id_centro;
	
	
	public Integer getId_medico() {
		return id_medico;
	}
	
	public Integer getId_centro() {
		return id_centro;
	}
	
	
}
