package ifce.viviservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nome;

    private String documento;

    @Column(unique = true)
    private String matricula;

    private Integer ddd;

    private Integer celular;

    private Integer status;

    @Column(unique = true)
    private String email;

    private Integer semestre;

    private Date dataIngresso;

    private Date dataEgresso;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAlteracao;

    private String usuarioAlteracao;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "autenticacao_id")
    private Autenticacao autenticacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id")
    private Campus campus;

}