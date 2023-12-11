package PROYECTO.EMTECH.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author HUAWEI PC
 */
@Data
@Entity
@Table(name="areas_puestos")
public class AreasPuestos implements Serializable{
    
    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="areas_puestos_seq_generador")
    @SequenceGenerator(name="areas_puestos_seq_generador", sequenceName="areas_puestos_seq",allocationSize=1)
    @Column(name="id_area_puesto")
    private Long idAreaPuesto;
    @Column(name="nombre_area")
    private String nombreArea;
    @Column(name="cantidad_vacantes")
    private int cantidadVacantes;
    private String descripcion;
    
     @OneToMany(mappedBy = "areasPuestos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private List<Puestos> puestos;

    public AreasPuestos() {
    }

    public AreasPuestos(String nombreArea, int cantidadVacantes, String descripcion, List<Puestos> puestos) {
        this.nombreArea = nombreArea;
        this.cantidadVacantes = cantidadVacantes;
        this.descripcion = descripcion;
        this.puestos = puestos;
    }
 
}
