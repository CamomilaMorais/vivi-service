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
public class Curriculo {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String descricao;

    private Integer status;

    private String linkedin;

    private String github;

    private Integer periodoDisponivel;

    private Integer nivelIngles;

    private Integer nivelEspanhol;

    private String competencias;

    private String observacoes;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAlteracao;

    private String usuarioAlteracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

}