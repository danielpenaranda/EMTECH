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
@Table(name="requisitos")
public class Requisitos implements Serializable{
    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="requisitos_seq_generador")
    @SequenceGenerator(name="requisitos_seq_generador", sequenceName="requisitos_seq",allocationSize=1)
    @Column(name="id_requisitos")
    private Long idRequisitos;
    private String descripcion;
    
    @OneToMany(mappedBy = "requisitos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Puestos> puestos;

    public Requisitos() {
    }

    public Requisitos(String descripcion, List<Puestos> puestos) {
        this.descripcion = descripcion;
        this.puestos = puestos;
    }
    
    
}
