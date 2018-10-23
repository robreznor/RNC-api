package cl.minsal.api.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tratamiento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String descripcion_tratamiento;
	private Integer estado_tratamiento;
	private String medicos_participantes;
	private String nombre_medico_tratante;
	private String resolucion_comite;
	private String descripcion_resolucion;
	
	@ManyToOne
	@JoinColumn(name="id_paciente", nullable=false)
	private Paciente paciente;
	
	@ManyToOne
    @JoinColumn(name="id_diagnostico", nullable=false)
	private Diagnostico diagnostico;
	
	@OneToMany(mappedBy="tratamiento")
	private Set<Tratamiento_indicado> tratamiento_indicado;
	
	public Integer getId() {
		return id;
	}
	public String getDescripcion_tratamiento() {
		return descripcion_tratamiento;
	}
	public Integer getEstado_tratamiento() {
		return estado_tratamiento;
	}
	public String getMedicos_participantes() {
		return medicos_participantes;
	}
	public String getNombre_medico_tratante() {
		return nombre_medico_tratante;
	}
	public String getResolucion_comite() {
		return resolucion_comite;
	}
	public String getDescripcion_resolucion() {
		return descripcion_resolucion;
	}
	
	public Set<Tratamiento_indicado> getTratamiento_indicado() {
		return tratamiento_indicado;
	}
		
}
