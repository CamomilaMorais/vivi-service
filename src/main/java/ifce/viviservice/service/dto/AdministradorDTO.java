package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AdministradorDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    private String usuarioAlteracao;

    private Long codigoAutenticacao;

    @NotNull
    private Long codigoCampus;

}