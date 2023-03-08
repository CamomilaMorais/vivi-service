package ifce.viviservice.service;

import ifce.viviservice.entity.Campus;
import ifce.viviservice.entity.Dominio;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.DominioRepository;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.DominioDTO;
import ifce.viviservice.service.mapper.DominioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class DominioService {

    @Autowired
    private DominioRepository repository;
    @Autowired
    private DominioMapper mapper;

    public CadastroDTO cadastrar(DominioDTO dto) {
        Dominio entity = this.mapper.toDominio(dto);
        entity.setStatus(1);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Dominio cadastrado " + entity)
                .build();
    }

    public List<DominioDTO> consultarPeloCodigo(String codigo) {
        List<Dominio> entities = this.repository.findAllById(Collections.singleton(codigo));
        return this.mapper.toListDominioDTO(entities);
    }

    public void remover(String codigo) throws RegisterNotFoundException {
        this.repository
                .findById(codigo)
                .map(entity -> {
                    this.repository.delete(entity);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
    }

    public void remover(String codigo, String valor) throws RegisterNotFoundException {
        Dominio entity = this.repository.findByCodigoAndValor(codigo, valor)
                .orElseThrow(() -> new RegisterNotFoundException(codigo, valor));
        this.repository.delete(entity);
    }

    public void atualizar(String codigo, String valor, DominioDTO dto) throws RegisterNotFoundException {
        Dominio entity = this.repository.findByCodigoAndValor(codigo, valor).orElseThrow(() -> new RegisterNotFoundException(codigo));
        LocalDateTime dataInclusao = entity.getDataInclusao();
        entity = this.mapper.toDominio(dto);
        entity.setCodigo(codigo);
        entity.setValor(valor);
        entity.setStatus(1);
        entity.setDataInclusao(dataInclusao);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

    public void desativar(String codigo, String valor, String usuario) throws RegisterNotFoundException {
        Dominio entity = this.repository.findByCodigoAndValor(codigo, valor).orElseThrow(() -> new RegisterNotFoundException(codigo));
        entity.setStatus(2);
        entity.setUsuarioAlteracao(usuario);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

}