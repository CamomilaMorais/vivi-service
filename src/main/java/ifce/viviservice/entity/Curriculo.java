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
@Table(name = "CURRICULO")
public class Curriculo {

    @Id
    @Column(name = "CODIGO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "URL_LINKEDIN")
    private String linkedin;

    @Column(name = "URL_GITHUB")
    private String github;

    @Column(name = "PERIODO_DISPONIVEL")
    private Integer periodoDisponivel;

    @Column(name = "NIVEL_INGLES")
    private Integer nivelIngles;

    @Column(name = "NIVEL_ESPANHOL")
    private Integer nivelEspanhol;

    @Column(name = "COMPETENCIAS")
    private String competencias;

    @Column(name = "OBSERVACOES")
    private String observacoes;

    @Column(name = "DATA_INCLUSAO")
    private LocalDateTime dataInclusao;

    @Column(name = "DATA_ALTERACAO")
    private LocalDateTime dataAlteracao;

    @Column(name = "USUARIO_ALTERACAO")
    private String usuarioAlteracao;

}