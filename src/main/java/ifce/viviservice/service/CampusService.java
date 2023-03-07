package ifce.viviservice.service;

import ifce.viviservice.entity.Administrador;
import ifce.viviservice.entity.Campus;
import ifce.viviservice.repository.AdministradorRepository;
import ifce.viviservice.repository.CampusRepository;
import ifce.viviservice.service.dto.AdministradorDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.CampusDTO;
import ifce.viviservice.service.mapper.AdministradorMapper;
import ifce.viviservice.service.mapper.CampusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CampusService {

    @Autowired
    private CampusRepository repository;
    @Autowired
    private CampusMapper mapper;

    public CadastroDTO create(CampusDTO dto) {
        Campus entity = this.mapper.toCampus(dto);
        entity.setStatus(1);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Campus criado com ID " + entity.getCodigo())
                .build();
    }

}