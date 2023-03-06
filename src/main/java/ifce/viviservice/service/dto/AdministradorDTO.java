package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
public class AdministradorDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    @NotBlank
    private Integer status;

    private String usuarioAlteracao;

    @Valid
    private AutenticacaoDTO autenticacao;

    @Valid
    private CampusDTO campus;

}