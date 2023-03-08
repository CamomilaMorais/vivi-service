package ifce.viviservice.service.mapper;

import ifce.viviservice.entity.Experiencia;
import ifce.viviservice.service.dto.ExperienciaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExperienciaMapper {

    @Autowired
    private ModelMapper mapper;

    public Experiencia toExperiencia(ExperienciaDTO dto) {
        return this.mapper.map(dto, Experiencia.class);
    }

    public ExperienciaDTO toExperienciaDTO(Experiencia entity) {
        return this.mapper.map(entity, ExperienciaDTO.class);
    }

}