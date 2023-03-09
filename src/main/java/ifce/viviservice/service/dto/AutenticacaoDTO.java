package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AutenticacaoDTO {

    @NotBlank
    private String usuario;

    @NotBlank
    private String senha;

    @NotNull
    private String perfil;

    private String usuarioAlteracao;

    @NotNull
    private Integer politicaPrivacidade;

}