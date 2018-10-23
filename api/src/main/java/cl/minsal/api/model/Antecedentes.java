package cl.minsal.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Antecedentes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private Date fecha_primera_consulta;
	private String breve_historia;
	private Integer motivo_derivacion;
	
	@OneToOne
    @JoinColumn(name = "id")
    private Paciente paciente;
	
	public Integer getId() {
		return id;
	}
	public Date getFecha_primera_consulta() {
		return fecha_primera_consulta;
	}
	public String getBreve_historia() {
		return breve_historia;
	}
	public Integer getMotivo_derivacion() {
		return motivo_derivacion;
	}
	
	
}
