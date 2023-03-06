package ifce.viviservice.service;

import ifce.viviservice.entity.Administrador;
import ifce.viviservice.repository.AdministradorRepository;
import ifce.viviservice.service.dto.AdministradorDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.mapper.AdministradorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository repository;
    @Autowired
    private AdministradorMapper mapper;

    @PostMapping
    public CadastroDTO create(@RequestBody @Valid AdministradorDTO dto) {
        Administrador entity = this.mapper.toAdministrador(dto);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Administrador criado com ID " + entity.getId())
                .build();
    }

}