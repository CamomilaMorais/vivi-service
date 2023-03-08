package ifce.viviservice.service.mapper;

import ifce.viviservice.entity.Curriculo;
import ifce.viviservice.service.dto.CurriculoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurriculoMapper {

    @Autowired
    private ModelMapper mapper;

    public Curriculo toCurriculo(CurriculoDTO dto) {
        return this.mapper.map(dto, Curriculo.class);
    }

    public CurriculoDTO toCurriculoDTO(Curriculo entity) {
        return this.mapper.map(entity, CurriculoDTO.class);
    }

}