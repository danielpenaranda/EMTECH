package PROYECTO.EMTECH.service.impl;

import PROYECTO.EMTECH.dao.PuestosDao;
import PROYECTO.EMTECH.domain.Puestos;
import PROYECTO.EMTECH.service.InsertarPuestos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author HUAWEI PC
 */
@Service
public class InsertarPuestosImpl implements InsertarPuestos {

    private final JdbcTemplate jdbcTemplate;
    private final PuestosDao puestosDao;

    @Autowired
    public InsertarPuestosImpl(JdbcTemplate jdbcTemplate, PuestosDao puestosDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.puestosDao = puestosDao;
    }

    @Override
    public void insertarTodos(String nombreArea, int cantidadVacantes, String descripcion,
            String descripcionR, String nombrePuesto, int disponibles, Long id) {
        try {
            jdbcTemplate.update("CALL insertar_areas_puestos(?,?,?)", nombreArea, cantidadVacantes, descripcion);
            id = jdbcTemplate.queryForObject("SELECT id_area_puesto FROM areas_puestos WHERE nombre_area=?", Long.class, nombreArea);
            System.out.println(id);
            insertarRequisitos(descripcionR);
            insertarPuestos(nombrePuesto, disponibles, id, id);
            System.out.println("Inserto exitoso");
        } catch (Exception e) {
            System.err.println("ERROR AL INSERTAR PUESTOS COMPLETOS");
            e.printStackTrace();
        }
    }

    @Override
    public void insertarRequisitos(String descripcionR) {
        try {
            jdbcTemplate.update("CALL insertar_requisito(?)", descripcionR);
            System.out.println("Inserto exitoso");
        } catch (Exception e) {
            System.err.println("ERROR AL INSERTAR REQUISITOS");
            e.printStackTrace();
        }
    }

    @Override
    public void insertarPuestos(String nombrePuesto, int disponibles, Long idPA, Long idR) {
        try {
            jdbcTemplate.update("CALL insertar_puestos(?,?,?,?)", nombrePuesto, disponibles, idPA, idR);
            System.out.println("Inserto exitoso");
        } catch (Exception e) {
            System.err.println("ERROR AL INSERTAR PUESTOS");
            e.printStackTrace();
        }
    }

    @Override
    public List<Puestos> obtenerDatosPuestos() {
        return puestosDao.findAll();
    }

    @Override
    public Puestos getPuestosById(Long id) {

        return puestosDao.findById(id).orElse(null);
    }

}
