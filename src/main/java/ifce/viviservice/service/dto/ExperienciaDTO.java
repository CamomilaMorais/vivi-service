package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ExperienciaDTO {

    @NotBlank
    private String cargo;

    @NotNull
    private Integer empresa;

    private String usuarioAlteracao;

    @NotNull
    private Long codigoCurriculo;

}