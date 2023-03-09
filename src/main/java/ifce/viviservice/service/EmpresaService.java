package ifce.viviservice.service;

import ifce.viviservice.entity.Administrador;
import ifce.viviservice.entity.Empresa;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.EmpresaRepository;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.EmpresaDTO;
import ifce.viviservice.service.mapper.EmpresaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;
    @Autowired
    private EmpresaMapper mapper;

    public CadastroDTO cadastrar(EmpresaDTO dto) {
        Empresa entity = this.mapper.toEmpresa(dto);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Empresa cadastrada com ID " + entity.getCodigo())
                .build();
    }

    public EmpresaDTO consultarPeloCodigo(Long codigo) throws RegisterNotFoundException {
        Empresa entity = this.repository.findById(codigo)
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
        return this.mapper.toEmpresaDTO(entity);
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

    public void atualizar(Long codigo, EmpresaDTO dto) throws RegisterNotFoundException {
        Empresa entity = this.repository.findById(codigo).orElseThrow(() -> new RegisterNotFoundException(codigo));
        LocalDateTime dataInclusao = entity.getDataInclusao();
        entity = this.mapper.toEmpresa(dto);
        entity.setCodigo(codigo);
        entity.setStatus(1);
        entity.setDataInclusao(dataInclusao);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

    public void desativar(Long codigo, String usuario) throws RegisterNotFoundException {
        Empresa entity = this.repository.findById(codigo).orElseThrow(() -> new RegisterNotFoundException(codigo));
        entity.setStatus(2);
        entity.setUsuarioAlteracao(usuario);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

}