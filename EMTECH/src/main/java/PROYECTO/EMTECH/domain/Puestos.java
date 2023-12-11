package PROYECTO.EMTECH.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author HUAWEI PC
 */
@Data
@Entity
@Table(name="puestos")
public class Puestos implements Serializable{
    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="puestos_seq_generador")
    @SequenceGenerator(name="puestos_seq_generador", sequenceName="puestos_seq",allocationSize=1)
    @Column(name="id_puestos")
    private Long idPuestos;
    @Column(name="nombre_puesto")
    private String nombrePuesto;
    private int disponibles;
    @Column(name="id_area_puesto")
    private Long idAreaPuesto;
    @Column(name="id_requisitos")
    private Long idRequisitos;
    
     @ManyToOne
    @JoinColumn(name = "id_area_puesto", referencedColumnName = "id_area_puesto", insertable = false, updatable = false)
    private AreasPuestos  areasPuestos;
     
     @ManyToOne
    @JoinColumn(name = "id_requisitos", referencedColumnName = "id_requisitos", insertable = false, updatable = false)
    private Requisitos requisitos;

    public Puestos() {
    }

    public Puestos(String nombrePuesto, int disponibles, Long idAreaPuesto, Long idRequisitos, AreasPuestos areasPuestos, Requisitos requisitos) {
        this.nombrePuesto = nombrePuesto;
        this.disponibles = disponibles;
        this.idAreaPuesto = idAreaPuesto;
        this.idRequisitos = idRequisitos;
        this.areasPuestos = areasPuestos;
        this.requisitos = requisitos;
    }
}
