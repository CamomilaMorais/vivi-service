package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CursoDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Integer qtdSemestres;

    @NotNull
    private Integer status;

    private String usuarioAlteracao;

    @Valid
    private CampusDTO campus;

}