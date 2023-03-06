package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DominioDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private String valor;

    @NotNull
    private Integer status;

    private String usuarioAlteracao;

    @Valid
    private CampusDTO campus;

}