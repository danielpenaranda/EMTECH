
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
@Table(name="curriculum")
public class Curriculum implements Serializable{
    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="curriculum_seq_generador")
    @SequenceGenerator(name="curriculum_seq_generador", sequenceName="curriculum_seq",allocationSize=1)
    @Column(name="id_curriculum")
    private Long idCurriculum;
    private String educacion;
    private String reconocimiento;
    private String idiomas;
    @Column(name="experiencia_laboral")
    private String experienciaLaboral;

    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Candidatos> candidatos;
    
    
    
}
