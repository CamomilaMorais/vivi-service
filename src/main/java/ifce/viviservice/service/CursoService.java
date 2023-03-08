package ifce.viviservice.service;

import ifce.viviservice.entity.Campus;
import ifce.viviservice.entity.Curso;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.CursoRepository;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.CursoDTO;
import ifce.viviservice.service.mapper.CursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;
    @Autowired
    private CursoMapper mapper;

    public CadastroDTO cadastrar(CursoDTO dto) {
        Curso entity = this.mapper.toCurso(dto);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Curso cadastrado com ID " + entity.getCodigo())
                .build();
    }

    public CursoDTO consultarPeloCodigo(Long codigo) throws RegisterNotFoundException {
        Curso entity = this.repository.findById(codigo)
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
        return this.mapper.toCursoDTO(entity);
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

    public void atualizar(Long codigo, CursoDTO dto) throws RegisterNotFoundException {
        Curso entity = this.repository.findById(codigo).orElseThrow(() -> new RegisterNotFoundException(codigo));
        LocalDateTime dataInclusao = entity.getDataInclusao();
        entity = this.mapper.toCurso(dto);
        entity.setCodigo(codigo);
        entity.setStatus(1);
        entity.setDataInclusao(dataInclusao);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

    public void desativar(Long codigo, String usuario) throws RegisterNotFoundException {
        Curso entity = this.repository.findById(codigo).orElseThrow(() -> new RegisterNotFoundException(codigo));
        entity.setStatus(2);
        entity.setUsuarioAlteracao(usuario);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

}