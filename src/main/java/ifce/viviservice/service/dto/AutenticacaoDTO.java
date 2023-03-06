package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AutenticacaoDTO {

    @NotBlank
    private String login;

    @NotBlank
    private String senha;

    @NotNull
    private Integer tipoPerfil;

    private String usuarioAlteracao;

    @NotNull
    private Integer politicaPrivacidade;

}