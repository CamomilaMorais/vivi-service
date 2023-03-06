package ifce.viviservice.service.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmpresaDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    private String usuarioAlteracao;

    @Valid
    private AutenticacaoDTO autenticacao;

    @Valid
    private CampusDTO campus;

}