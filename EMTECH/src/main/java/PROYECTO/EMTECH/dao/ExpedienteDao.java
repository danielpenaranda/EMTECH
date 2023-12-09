/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PROYECTO.EMTECH.dao;

import PROYECTO.EMTECH.domain.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HUAWEI PC
 */
public interface ExpedienteDao extends JpaRepository <Expediente,Long>{
    
}
