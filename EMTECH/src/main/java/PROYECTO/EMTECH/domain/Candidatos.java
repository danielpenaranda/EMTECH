package PROYECTO.EMTECH.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author HUAWEI PC
 */
@Data
@Entity
@Table(name="candidatos")
public class Candidatos implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_candidato")
    private Long idCandidato;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    @Column(name="id_curriculum")
    private int idCurriculum;
    @Column(name="id_expediente")
    private int idExpediente;
    
    @ManyToOne
    @JoinColumn(name = "id_expediente", referencedColumnName = "id_expediente", insertable = false, updatable = false)
    private Expediente expediente;
    
    @ManyToOne
    @JoinColumn(name = "id_curriculum", referencedColumnName = "id_curriculum",insertable = false, updatable = false)
    private Curriculum curriculum;

    public Candidatos() {
    }

    public Candidatos(String nombre, String apellido, String correo, String telefono, int idCurriculum, int idExpediente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.idCurriculum = idCurriculum;
        this.idExpediente = idExpediente;
    }

}
