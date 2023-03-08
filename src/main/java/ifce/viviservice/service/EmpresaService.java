package ifce.viviservice.service;

import ifce.viviservice.entity.Empresa;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.EmpresaRepository;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.EmpresaDTO;
import ifce.viviservice.service.mapper.EmpresaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

}