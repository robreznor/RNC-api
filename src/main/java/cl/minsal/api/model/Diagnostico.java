package cl.minsal.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Diagnostico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String tipo_comite;
	private Date fecha_diagnostico;
	private String diagnostico_ingreso;
	private String diagnostico_comite;
	private String diagnostico_cie10;
	private String ecog;
	private String tnm;
	private String estadio;
	
	@ManyToOne
    @JoinColumn(name="id_paciente", nullable=false)
	private Paciente paciente;
	
	@OneToMany(mappedBy="diagnostico")
	private Set<Tratamiento> tratamiento;
	
	public Integer getId() {
		return id;
	}
	public String getTipo_comite() {
		return tipo_comite;
	}
	public Date getFecha_diagnostico() {
		return fecha_diagnostico;
	}
	public String getDiagnostico_ingreso() {
		return diagnostico_ingreso;
	}
	public String getDiagnostico_comite() {
		return diagnostico_comite;
	}
	public String getDiagnostico_cie10() {
		return diagnostico_cie10;
	}
	public String getEcog() {
		return ecog;
	}
	public String getTnm() {
		return tnm;
	}
	public String getEstadio() {
		return estadio;
	}	
	
	public Set<Tratamiento> getTratamiento(){
		return tratamiento;
	}
}
