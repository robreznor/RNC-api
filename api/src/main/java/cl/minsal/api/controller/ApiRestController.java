package cl.minsal.api.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import cl.minsal.api.object.FileBucket;
import cl.minsal.api.object.PacienteData;
import cl.minsal.api.util.FileValidator;
import cl.minsal.api.model.Paciente;
import cl.minsal.api.model.PacienteSearch;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

@RestController
public class ApiRestController {
	
    private static String UPLOAD_LOCATION="C:/aasdsad/";
    
    @Autowired
    FileValidator fileValidator;
//
//    @InitBinder("fileBucket")
//    protected void initBinderFileBucket(WebDataBinder binder) {
//        binder.setValidator(fileValidator);
//    }
    
	@RequestMapping(value="/paciente_search", method=RequestMethod.GET)
    public List<PacienteSearch> pacienteSearch() {
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from PacienteSearch");
        List<PacienteSearch> pacientes = q.list();
      
        return pacientes;
    }
	
	@RequestMapping(value="/paciente", method=RequestMethod.GET)
    public List<Paciente> pacientes() {
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Paciente");
        List<Paciente> pacientes = q.list();
      
        return pacientes;
    }
	
	@RequestMapping(value="/paciente/{id}", method=RequestMethod.GET)
	private Paciente search(@PathVariable Integer id){
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Paciente p where p.id= '" + id + "'");
        List<Paciente> pacientes = q.list();
        
		return pacientes.get(0);
	}
	
	@RequestMapping(value="/paciente_data/{id}", method=RequestMethod.GET)
	private PacienteData paciente_data(@PathVariable Integer id){
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Paciente p where p.id= '" + id + "'");
        List<Paciente> pacientes = q.list();
        Paciente paciente = pacientes.get(0);
        PacienteData paciente_data = new PacienteData();
        paciente_data.setNombre(paciente.getNombre() + ' ' + paciente.getApellido1() + ' ' + paciente.getApellido2());
        paciente_data.setRut(Integer.toString(paciente.getRut()) + '-' + paciente.getDigito_verificador());
        paciente_data.setSexo(paciente.getGenero());
        paciente_data.setFechaNacimiento(dateFormat.format(paciente.getFecha_nacimiento()));
        paciente_data.setFechaPrimeraConsulta(dateFormat.format(paciente.getAntecedentes().getFecha_primera_consulta()));
		return paciente_data;
	}
	
	@RequestMapping(value="/paciente_primera_consulta/{id}", method=RequestMethod.GET)
	private Paciente paciente_primera_consulta(@PathVariable Integer id){
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession(); 
        Query q = session.createQuery("from Paciente p where p.id= '" + id + "'");
        List<Paciente> pacientes = q.list();
        
		return pacientes.get(0);
	}
	
	@RequestMapping(value="/paciente_diagnostico/{id}", method=RequestMethod.GET)
	private Paciente paciente_diagnostico(@PathVariable Integer id){
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Paciente p where p.id= '" + id + "'");
        List<Paciente> pacientes = q.list();
        
		return pacientes.get(0);
	}
	
	@RequestMapping(value="/tratamiento/{id}", method=RequestMethod.GET)
	private Paciente paciente_tratamiento(@PathVariable Integer id){
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Paciente p where p.id= '" + id + "'");
        List<Paciente> pacientes = q.list();
        
		return pacientes.get(0);
	}
	
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
    public String singleFileUpload(@Valid FileBucket fileBucket,
            BindingResult result, ModelMap model) throws IOException {
		
        if (result.hasErrors()) {
            System.out.println("validation errors");
            return "failed";
        } else {
//        	System.out.println(fileBucket);
//        	System.out.println(fileBucket.getFile().getOriginalFilename());
//          System.out.println("Fetching file");
            MultipartFile multipartFile = fileBucket.getFile();
 
            // Now do something with file...
            FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File( UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename()));
            String fileName = multipartFile.getOriginalFilename();
            model.addAttribute("fileName", fileName);
            return "success";
        }
    }
}
