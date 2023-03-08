package ifce.viviservice.service.mapper;

import ifce.viviservice.entity.Dominio;
import ifce.viviservice.service.dto.DominioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DominioMapper {

    @Autowired
    private ModelMapper mapper;

    public Dominio toDominio(DominioDTO dto) {
        return this.mapper.map(dto, Dominio.class);
    }

    public DominioDTO toDominioDTO(Dominio entity) {
        return this.mapper.map(entity, DominioDTO.class);
    }

    public List<DominioDTO> toListDominioDTO(List<Dominio> entities) {
        List<DominioDTO> dtos = new ArrayList<>();
        for (Dominio e : entities) {
            dtos.add(this.mapper.map(e, DominioDTO.class));
        }
        return dtos;
    }

}