package PROYECTO.EMTECH.Controller;

import PROYECTO.EMTECH.domain.Puestos;
import PROYECTO.EMTECH.service.InsertarPuestos;
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
public class AreasPuestosController {
    
    private final InsertarPuestos insertarPuestos;

    @Autowired
    public AreasPuestosController(InsertarPuestos insertarPuestos) {
        this.insertarPuestos = insertarPuestos;
    }
    
    @GetMapping("/puestos")
    public String puestos(){
        return "puestos";
    }
    
    @PostMapping("/insertarPuestos")
    public String insertarTodos(String nombreArea, int cantidadVacantes, String descripcion,
             String descripcionR,
            String nombrePuesto,int disponibles,Long id){
        insertarPuestos.insertarTodos(nombreArea, cantidadVacantes, descripcion, descripcionR, nombrePuesto, disponibles, id);
        return "redirect:/puestos";
    }
    
    @GetMapping("/listaPuestos")
    public String listaPuestos(Model model){
        List<Puestos>puestos=insertarPuestos.obtenerDatosPuestos();
        model.addAttribute("puestos", puestos);
        return "listaPuestos";
    }
      
    @GetMapping("/datosPuestos/{id}")
     public String datosPuestos(@PathVariable Long id,Model model){
        Puestos puesto = insertarPuestos.getPuestosById(id);
        model.addAttribute("puesto", puesto);
        return "datosPuestos";
     }
    
    
    
    
    
}
