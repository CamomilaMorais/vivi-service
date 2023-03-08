package ifce.viviservice.service;

import ifce.viviservice.entity.Curso;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.CursoRepository;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.CursoDTO;
import ifce.viviservice.service.mapper.CursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

}