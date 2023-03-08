package ifce.viviservice.service.mapper;

import ifce.viviservice.entity.Autenticacao;
import ifce.viviservice.service.dto.AutenticacaoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutenticacaoMapper {

    @Autowired
    private ModelMapper mapper;

    public Autenticacao toAutenticacao(AutenticacaoDTO dto) {
        return this.mapper.map(dto, Autenticacao.class);
    }

    public AutenticacaoDTO toAutenticacaoDTO(Autenticacao entity) {
        return this.mapper.map(entity, AutenticacaoDTO.class);
    }

}