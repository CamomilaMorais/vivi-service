package ifce.viviservice.service.mapper;

import ifce.viviservice.entity.Empresa;
import ifce.viviservice.service.dto.EmpresaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpresaMapper {

    @Autowired
    private ModelMapper mapper;

    public Empresa toEmpresa(EmpresaDTO dto) {
        return this.mapper.map(dto, Empresa.class);
    }

    public EmpresaDTO toEmpresaDTO(Empresa entity) {
        return this.mapper.map(entity, EmpresaDTO.class);
    }

}