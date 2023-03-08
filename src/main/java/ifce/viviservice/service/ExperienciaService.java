package ifce.viviservice.service;

import ifce.viviservice.entity.Administrador;
import ifce.viviservice.entity.Experiencia;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.ExperienciaRepository;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.ExperienciaDTO;
import ifce.viviservice.service.mapper.ExperienciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository repository;
    @Autowired
    private ExperienciaMapper mapper;

    public CadastroDTO cadastrar(ExperienciaDTO dto) {
        Experiencia entity = this.mapper.toExperiencia(dto);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Experiencia cadastrada com ID " + entity.getCodigo())
                .build();
    }

    public ExperienciaDTO consultarPeloCodigo(Long codigo) throws RegisterNotFoundException {
        Experiencia entity = this.repository.findById(codigo)
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
        return this.mapper.toExperienciaDTO(entity);
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

    public void atualizar(Long codigo, ExperienciaDTO dto) throws RegisterNotFoundException {
        Experiencia entity = this.repository.findById(codigo).orElseThrow(() -> new RegisterNotFoundException(codigo));
        LocalDateTime dataInclusao = entity.getDataInclusao();
        entity = this.mapper.toExperiencia(dto);
        entity.setCodigo(codigo);
        entity.setDataInclusao(dataInclusao);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

}