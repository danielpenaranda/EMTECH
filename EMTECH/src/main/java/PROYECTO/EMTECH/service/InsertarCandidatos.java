package PROYECTO.EMTECH.service;

import PROYECTO.EMTECH.domain.Candidatos;
import java.util.List;

/**
 *
 * @author HUAWEI PC
 */
public interface InsertarCandidatos {
    void insertarTodos(String incidentes, String desempeno,
            String educacion, String reconocimientos, String idiomas, String experienciaLaboral,
            String nombre,String apellido, String correo, String telefono, Long id);
    
    void insertarCurriculum( String educacion, String reconocimientos, String idiomas, String experienciaLaboral);
    
    void insertarCandidatos(String nombre,String apellido, String correo, String telefono, Long idE, Long idC);
    
    List<Candidatos>obtenerDatosCandidato();
    
    Candidatos getCandidatosById(Long id);
}
