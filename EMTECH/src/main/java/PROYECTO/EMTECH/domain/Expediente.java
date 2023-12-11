package PROYECTO.EMTECH.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author HUAWEI PC
 */
@Data
@Entity
@Table(name= "expedientes")
public class Expediente implements Serializable{
    
    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="expedientes_seq_generador")
    @SequenceGenerator(name="expedientes_seq_generador", sequenceName="expedientes_seq",allocationSize=1)
    @Column(name="id_expediente")
    private Long idExpediente;
    private String incidentes;
    private String desempeno;

    @OneToMany(mappedBy = "expediente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Candidatos> candidatos;
    
    public Expediente() {
    }

    public Expediente(String incidentes, String desempeno) {
        this.incidentes = incidentes;
        this.desempeno = desempeno;
    }
    
}
