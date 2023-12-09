package PROYECTO.EMTECH.service.impl;

import PROYECTO.EMTECH.service.InsertarCandidatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author HUAWEI PC
 */
@Service
public class InsertarCandidatosImpl implements InsertarCandidatos{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public InsertarCandidatosImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;        
    }
    
    @Override
    public void insertarTodos(String incidentes, String desempeno, String educacion, String reconocimientos, String idiomas, String experienciaLaboral, String nombre, String apellido, String correo, String telefono, Long id) {
        try{
         jdbcTemplate.update("CALL insertar_expediente(?,?)",incidentes, desempeno);
            id=jdbcTemplate.queryForObject("SELECT id_expediente FROM expedientes WHERE desempeno=?", Long.class, desempeno);
            System.out.println(id);
            insertarCurriculum(educacion, reconocimientos, idiomas, experienciaLaboral);
            insertarCandidatos(nombre, apellido, correo, telefono, id, id);
            System.out.println("Inserto exitoso");
    }catch(Exception e){
        System.err.println("ERROR AL INSERTAR CANDIDATOS3");
        e.printStackTrace();
    }
    
    }

    @Override
    public void insertarCurriculum(String educacion, String reconocimientos, String idiomas, String experienciaLaboral) {
       try{
        jdbcTemplate.update("CALL insertar_curriculum(?,?,?,?)",educacion, reconocimientos, idiomas, experienciaLaboral);
            System.out.println("Inserto exitoso");
            
    }catch(Exception e){
        System.err.println("ERROR AL INSERTAR CANDIDATOS3");
        e.printStackTrace();
    }
    
    }

    @Override
    public void insertarCandidatos(String nombre, String apellido, String correo, String telefono, Long idE, Long idC) {
        try{
        jdbcTemplate.update("CALL insertar_candidatos(?,?,?,?,?,?)",nombre, apellido, correo, telefono, idC, idE);
            System.out.println("Inserto exitoso");
    }catch(Exception e){
        System.err.println("ERROR AL INSERTAR CANDIDATOS1");
        e.printStackTrace();
    }
    }
    
}
