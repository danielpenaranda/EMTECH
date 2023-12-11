package PROYECTO.EMTECH.Controller;

import PROYECTO.EMTECH.domain.Servicios;
import PROYECTO.EMTECH.service.InsertarServicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HUAWEI PC
 */
@Controller
public class ServiciosController {
    
    private final InsertarServicios insertarServicios;

    @Autowired
    public ServiciosController(InsertarServicios insertarServicios) {
        this.insertarServicios = insertarServicios;
    }
    
     @GetMapping("/servicios")
    public String servicios(){
        return "servicios";
    }
    
    @PostMapping("/insertarServicios")
    public String insertarTodos(String nombreServicio, String telefono, String email, String idDS, String idC){
        Long idDireccion= Long.parseLong(idDS);
        Long idCompania= Long.parseLong(idC);
        insertarServicios.insertarServicios(nombreServicio, telefono, email, idDireccion, idCompania);
        return "redirect:/servicios";
    }
    
    @GetMapping("/listaServicios")
    public String listaServicios(Model model){
        List<Servicios>servicios=insertarServicios.obtenerDatosServicio();
        model.addAttribute("servicios", servicios);
        return "listaServicios";
    }
}
