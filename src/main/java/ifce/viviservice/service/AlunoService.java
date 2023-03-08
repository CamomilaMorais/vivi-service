package ifce.viviservice.service;

import ifce.viviservice.entity.Aluno;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.AlunoRepository;
import ifce.viviservice.service.dto.AlunoDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.mapper.AlunoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;
    @Autowired
    private AlunoMapper mapper;

    public CadastroDTO cadastrar(AlunoDTO dto) {
        Aluno entity = this.mapper.toAluno(dto);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Aluno(a) cadastrado(a) com ID " + entity.getCodigo())
                .build();
    }

    public AlunoDTO consultarPeloCodigo(Long codigo) throws RegisterNotFoundException {
        Aluno entity = this.repository.findById(codigo)
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
        return this.mapper.toAlunoDTO(entity);
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