package ifce.viviservice.service.mapper;

import ifce.viviservice.entity.Curso;
import ifce.viviservice.service.dto.CursoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    @Autowired
    private ModelMapper mapper;

    public Curso toCurso(CursoDTO dto) {
        return this.mapper.map(dto, Curso.class);
    }

    public CursoDTO toCursoDTO(Curso entity) {
        return this.mapper.map(entity, CursoDTO.class);
    }

}