package ifce.viviservice.service;

import ifce.viviservice.entity.Administrador;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.AdministradorRepository;
import ifce.viviservice.service.dto.AdministradorDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.mapper.AdministradorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository repository;
    @Autowired
    private AdministradorMapper mapper;

    public CadastroDTO cadastrar(AdministradorDTO dto) {
        Administrador entity = this.mapper.toAdministrador(dto);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Administrador(a) cadastrado(a) com ID " + entity.getCodigo())
                .build();
    }

    public AdministradorDTO consultarPeloCodigo(Long codigo) throws RegisterNotFoundException {
        Administrador entity = this.repository.findById(codigo)
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
        return this.mapper.toAdministradorDTO(entity);
    }

    public void remover(Long codigo) throws RegisterNotFoundException {
        this.repository
                .findById(codigo)
                .map(entity -> {
                    this.repository.delete(entity);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
    }

}