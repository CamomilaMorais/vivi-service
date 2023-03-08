package ifce.viviservice.service.mapper;

import ifce.viviservice.entity.Administrador;
import ifce.viviservice.service.dto.AdministradorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdministradorMapper {

    @Autowired
    private ModelMapper mapper;

    public Administrador toAdministrador(AdministradorDTO dto) {
        return this.mapper.map(dto, Administrador.class);
    }

    public AdministradorDTO toAdministradorDTO(Administrador entity) {
        return this.mapper.map(entity, AdministradorDTO.class);
    }

}