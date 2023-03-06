package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CurriculoDTO {

    @NotBlank
    private String descricao;

    @NotNull
    private Integer status;

    private String linkedin;

    private String github;

    @NotNull
    private Integer periodoDisponivel;

    @NotNull
    private Integer nivelIngles;

    @NotNull
    private Integer nivelEspanhol;

    private String competencias;

    private String observacoes;

    private String usuarioAlteracao;

    @Valid
    private AlunoDTO aluno;

}