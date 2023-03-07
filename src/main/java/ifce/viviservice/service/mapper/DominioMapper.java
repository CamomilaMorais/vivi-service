package ifce.viviservice.service.mapper;

import ifce.viviservice.entity.Dominio;
import ifce.viviservice.service.dto.DominioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DominioMapper {

    @Autowired
    private ModelMapper mapper;

    public Dominio toCampus(DominioDTO dto) {
        return this.mapper.map(dto, Dominio.class);
    }

}