package PROYECTO.EMTECH.service;

import PROYECTO.EMTECH.domain.Puestos;
import java.util.List;

/**
 *
 * @author HUAWEI PC
 */
public interface InsertarPuestos {
     void insertarTodos(String nombreArea, int cantidadVacantes, String descripcion,
             String descripcionR,
            String nombrePuesto,int disponibles,Long id);
    
    void insertarRequisitos(String descripcionR);
    
    void insertarPuestos(String nombrePuesto,int disponibles,Long idPA, Long idR);
    
    List<Puestos>obtenerDatosPuestos();
    
    Puestos getPuestosById(Long id);
}
