package PROYECTO.EMTECH.Controller;

import PROYECTO.EMTECH.service.InsertarCandidatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HUAWEI PC
 */
@Controller
public class CandidatosController {
   
    private final InsertarCandidatos insertarCandidatos;
    
    @Autowired
    public CandidatosController(InsertarCandidatos insertarCandidatos){
        this.insertarCandidatos=insertarCandidatos;
    }
    
    @GetMapping("/candidatos")
    public String candidatos(){
        return "candidatos";
    }
    
    @PostMapping("/insertarCandidatos")
    public String insertarTodos(String incidentes, String desempeno,
            String educacion, String reconocimientos, String idiomas, String experienciaLaboral,
            String nombre,String apellido, String correo, String telefono, Long id){
        insertarCandidatos.insertarTodos(incidentes, desempeno, educacion, reconocimientos, idiomas, experienciaLaboral, nombre, apellido, correo, telefono, id);
        return "redirect:/candidatos?exito";
    }
    
    
    
}
