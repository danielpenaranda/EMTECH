package PROYECTO.EMTECH.service;

import PROYECTO.EMTECH.domain.Servicios;
import java.util.List;

/**
 *
 * @author HUAWEI PC
 */
public interface InsertarServicios {
    
     void insertarServicios(String nombreServicio,String telefono, String email, Long idDS, Long idC);
     
     List<Servicios>obtenerDatosServicio();
}
