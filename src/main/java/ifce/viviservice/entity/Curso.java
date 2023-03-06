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
public class Curso {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nome;

    private Integer qtdSemestres;

    private Integer status;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAlteracao;

    private String usuarioAlteracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id")
    private Campus campus;

}