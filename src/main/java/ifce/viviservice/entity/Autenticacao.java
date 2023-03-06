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
public class Autenticacao {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(unique = true)
    private String login;

    private String senha;

    private Integer tipoPerfil;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAlteracao;

    private String usuarioAlteracao;

    private Integer politicaPrivacidade;

}