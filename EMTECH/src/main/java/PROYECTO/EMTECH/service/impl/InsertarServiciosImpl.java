/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO.EMTECH.service.impl;

import PROYECTO.EMTECH.dao.ServiciosDao;
import PROYECTO.EMTECH.domain.Servicios;
import PROYECTO.EMTECH.service.InsertarServicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author HUAWEI PC
 */
@Service
public class InsertarServiciosImpl implements InsertarServicios{

    private final JdbcTemplate jdbcTemplate;
    private final ServiciosDao serviciosDao;

    @Autowired
    public InsertarServiciosImpl(JdbcTemplate jdbcTemplate, ServiciosDao serviciosDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.serviciosDao = serviciosDao;
    }
    
    
    @Override
    public void insertarServicios(String nombreServicio, String telefono, String email, Long idDS, Long idC) {
        try{
            jdbcTemplate.update("CALL insertar_servicio(?,?,?,?,?)", nombreServicio, telefono, email, idDS, idC);
            System.out.println("INSERTO EXITOSO!");
        }catch (Exception e) {
            System.err.println("ERROR AL INSERTAR SERVICIOS");
            e.printStackTrace();
        }
    }

    @Override
    public List<Servicios> obtenerDatosServicio() {
    return serviciosDao.findAll();
    }
    
}
