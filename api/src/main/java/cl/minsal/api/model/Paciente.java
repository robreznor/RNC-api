package cl.minsal.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Paciente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer rut;
	private String digito_verificador;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fecha_nacimiento;
	private Integer genero;
	private Integer nacionalidad;
	private Integer pueblo_originario;
	private Integer estado_conyugal;
	private Integer religion;
	private Integer nivel_instruccion;
	private Integer ocupacion;
	private Integer actividad_economica;
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Antecedentes id_antecedentes;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Localizacion id_localizacion;
	
	@OneToMany(mappedBy="paciente")
	private Set<Documentos> documento;
	
	@OneToMany(mappedBy="paciente")
	private Set<Diagnostico> diagnostico;
	
	@OneToMany(mappedBy="paciente")
	private Set<Tratamiento> tratamiento;

	public Integer getId(){
		return id;
	}

	public Integer getRut() {
		return rut;
	}

	public String getDigito_verificador() {
		return digito_verificador;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public Integer getGenero() {
		return genero;
	}


	public Integer getNacionalidad() {
		return nacionalidad;
	}


	public Integer getPueblo_originario() {
		return pueblo_originario;
	}


	public Integer getEstado_conyugal() {
		return estado_conyugal;
	}


	public Integer getReligion() {
		return religion;
	}


	public Integer getNivel_instruccion() {
		return nivel_instruccion;
	}


	public Integer getOcupacion() {
		return ocupacion;
	}


	public Integer getActividad_economica() {
		return actividad_economica;
	}


	public Antecedentes getAntecedentes() {
		return id_antecedentes;
	}


	public Localizacion getLocalizacion() {
		return id_localizacion;
	}
	
	public Set<Documentos> getDocumentos() {
		return documento;
	}
	
	public Set<Diagnostico> getDiagnosticos() {
		return diagnostico;
	}
	
	public Set<Tratamiento> getTratamiento() {
		return tratamiento;
	}

}
