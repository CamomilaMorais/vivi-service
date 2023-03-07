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
@Table(name = "EMPRESA")
public class Empresa {

    @Id
    @Column(name = "CODIGO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DOCUMENTO")
    private String documento;

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
            name = "AUTH_ID",
            referencedColumnName = "CODIGO",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private Autenticacao autenticacao;

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