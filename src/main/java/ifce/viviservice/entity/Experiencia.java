package ifce.viviservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Experiencia {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String cargo;

    private Integer empresa;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAlteracao;

    private String usuarioAlteracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;

}