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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DOMINIO")
public class Dominio {

    @Id
    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "VALOR")
    private String valor;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "DATA_INCLUSAO")
    private LocalDateTime dataInclusao;

    @Column(name = "DATA_ALTERACAO")
    private LocalDateTime dataAlteracao;

    @Column(name = "USUARIO_ALTERACAO")
    private String usuarioAlteracao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "CAMPUS_ID",
            referencedColumnName = "CODIGO",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private Campus campus;

}