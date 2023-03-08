package ifce.viviservice.service;

import ifce.viviservice.entity.Campus;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.CampusRepository;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.CampusDTO;
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

    public CadastroDTO cadastrar(CampusDTO dto) {
        Campus entity = this.mapper.toCampus(dto);
        entity.setStatus(1);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Campus cadastrado com ID " + entity.getCodigo())
                .build();
    }

    public CampusDTO consultarPeloCodigo(Long codigo) throws RegisterNotFoundException {
        Campus entity = this.repository.findById(codigo)
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
        return this.mapper.toCampusDTO(entity);
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

    public void atualizar(Long codigo, CampusDTO dto) throws RegisterNotFoundException {
        Campus entity = this.repository.findById(codigo).orElseThrow(() -> new RegisterNotFoundException(codigo));
        LocalDateTime dataInclusao = entity.getDataInclusao();
        entity = this.mapper.toCampus(dto);
        entity.setCodigo(codigo);
        entity.setStatus(1);
        entity.setDataInclusao(dataInclusao);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

    public void desativar(Long codigo, String usuario) throws RegisterNotFoundException {
        Campus entity = this.repository.findById(codigo).orElseThrow(() -> new RegisterNotFoundException(codigo));
        entity.setStatus(2);
        entity.setUsuarioAlteracao(usuario);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

}