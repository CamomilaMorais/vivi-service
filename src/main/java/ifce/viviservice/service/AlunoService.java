package ifce.viviservice.service;

import ifce.viviservice.entity.Administrador;
import ifce.viviservice.entity.Aluno;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.AlunoRepository;
import ifce.viviservice.service.dto.AlunoDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.mapper.AlunoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

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

    public void atualizar(Long codigo, AlunoDTO dto) throws RegisterNotFoundException {
        Aluno entity = this.repository.findById(codigo).orElseThrow(() -> new RegisterNotFoundException(codigo));
        LocalDateTime dataInclusao = entity.getDataInclusao();
        Date dataIngresso = entity.getDataIngresso();
        entity = this.mapper.toAluno(dto);
        entity.setCodigo(codigo);
        entity.setStatus(1);
        entity.setDataInclusao(dataInclusao);
        entity.setDataIngresso(dataIngresso);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

    public void desativar(Long codigo, String usuario) throws RegisterNotFoundException {
        Aluno entity = this.repository.findById(codigo).orElseThrow(() -> new RegisterNotFoundException(codigo));
        entity.setStatus(2);
        entity.setUsuarioAlteracao(usuario);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

}