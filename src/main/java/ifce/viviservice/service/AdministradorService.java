package ifce.viviservice.service;

import ifce.viviservice.entity.Administrador;
import ifce.viviservice.repository.AdministradorRepository;
import ifce.viviservice.service.dto.AdministradorDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.mapper.AdministradorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository repository;
    @Autowired
    private AdministradorMapper mapper;

    public CadastroDTO create(AdministradorDTO dto) {
        Administrador entity = this.mapper.toAdministrador(dto);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Administrador criado com ID " + entity.getCodigo())
                .build();
    }

}