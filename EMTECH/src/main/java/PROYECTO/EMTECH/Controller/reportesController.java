/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO.EMTECH.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HUAWEI PC
 */
@Controller
@RequestMapping("/reportes")
public class reportesController {
    @GetMapping("/reportes")
    public String mostrarReportes() {
        return "reportes/reportes";
    }
}
