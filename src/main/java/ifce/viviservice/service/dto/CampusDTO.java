package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CampusDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    @NotNull
    private Integer status;

    private String usuarioAlteracao;

}