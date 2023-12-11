package PROYECTO.EMTECH.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="servicios")
public class Servicios implements Serializable{
    
    private static final long serialiVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="servicios_seq_generador")
    @SequenceGenerator(name="servicios_seq_generador", sequenceName="servicios_seq",allocationSize=1)
    @Column(name="id_servicio")
    private Long idServicio;
    @Column(name="nombre_servicio")
    private String nombreServicio;
    private String telefono;
    private String email;
    @Column(name="id_direccion_servicios")
    private int idDireccionServicios;
    @Column(name="id_compania")
    private int idCompania;

    public Servicios() {
    }

    public Servicios(String nombreServicio, String telefono, String email, int idDireccionServicios, int idCompania) {
        this.nombreServicio = nombreServicio;
        this.telefono = telefono;
        this.email = email;
        this.idDireccionServicios = idDireccionServicios;
        this.idCompania = idCompania;
    }

    
    
    
    
    
}
