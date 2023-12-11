package PROYECTO.EMTECH.Controller;

import PROYECTO.EMTECH.domain.Candidatos;
import PROYECTO.EMTECH.service.InsertarCandidatos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/listaCandidatos")
    public String listaCandidatos(Model model){
        List<Candidatos>candidatos=insertarCandidatos.obtenerDatosCandidato();
        model.addAttribute("candidatos", candidatos);
        return "listaCandidatos";
    }
    
    @GetMapping("/datosCandidatos/{id}")
     public String datosCandidatos(@PathVariable Long id,Model model){
        Candidatos candidato = insertarCandidatos.getCandidatosById(id);
        model.addAttribute("candidato", candidato);
        return "datosCandidatos";
     }
    
    
    
}
