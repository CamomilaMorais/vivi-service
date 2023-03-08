package ifce.viviservice.service.mapper;

import ifce.viviservice.entity.Campus;
import ifce.viviservice.service.dto.CampusDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampusMapper {

    @Autowired
    private ModelMapper mapper;

    public Campus toCampus(CampusDTO dto) {
        return this.mapper.map(dto, Campus.class);
    }

    public CampusDTO toCampusDTO(Campus entity) {
        return this.mapper.map(entity, CampusDTO.class);
    }

}