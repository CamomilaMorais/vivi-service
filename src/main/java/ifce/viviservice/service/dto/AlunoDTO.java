package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AlunoDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    @NotBlank
    private String matricula;

    @NotNull
    private Integer ddd;

    @NotNull
    private Integer celular;

    @NotNull
    private Integer status;

    @NotBlank
    private String email;

    @NotNull
    private Integer semestre;

    @NotNull
    private Date dataIngresso;

    private Date dataEgresso;

    private String usuarioAlteracao;

    @Valid
    private AutenticacaoDTO autenticacao;

    @Valid
    private CursoDTO curso;

    @Valid
    private CampusDTO campus;

}