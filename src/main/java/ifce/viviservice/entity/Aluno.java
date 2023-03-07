package ifce.viviservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ALUNO")
public class Aluno {

    @Id
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DOCUMENTO")
    private String documento;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "NUMERO_DDD")
    private String ddd;

    @Column(name = "NUMERO_CELULAR")
    private String celular;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SEMESTRE")
    private Integer semestre;

    @Column(name = "DATA_INGRESSO")
    private Date dataIngresso;

    @Column(name = "DATA_EGRESSO")
    private Date dataEgresso;

    @Column(name = "DATA_INCLUSAO")
    private LocalDateTime dataInclusao;

    @Column(name = "DATA_ALTERACAO")
    private LocalDateTime dataAlteracao;

    @Column(name = "USUARIO_ALTERACAO")
    private String usuarioAlteracao;

    @OneToOne(fetch = FetchType.EAGER)
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
            name = "CURSO_ID",
            referencedColumnName = "CODIGO",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private Curso curso;

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