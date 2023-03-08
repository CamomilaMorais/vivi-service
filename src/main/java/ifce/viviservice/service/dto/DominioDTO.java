package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DominioDTO {

    @NotBlank
    private String codigo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String valor;

    private String usuarioAlteracao;

    @NotNull
    private Long codigoCampus;

}