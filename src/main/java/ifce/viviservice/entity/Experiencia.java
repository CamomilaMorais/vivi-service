package ifce.viviservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EXPERIENCIA")
public class Experiencia {

    @Id
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "CARGO")
    private String cargo;

    @Column(name = "EMPRESA")
    private Integer empresa;

    @Column(name = "DATA_INCLUSAO")
    private LocalDateTime dataInclusao;

    @Column(name = "DATA_ALTERACAO")
    private LocalDateTime dataAlteracao;

    @Column(name = "USUARIO_ALTERACAO")
    private String usuarioAlteracao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "CURRICULO_ID",
            referencedColumnName = "CODIGO",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private Curriculo curriculo;

}