package ifce.viviservice.service;

import ifce.viviservice.entity.Curriculo;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.CurriculoRepository;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.CurriculoDTO;
import ifce.viviservice.service.mapper.CurriculoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository repository;
    @Autowired
    private CurriculoMapper mapper;

    public CadastroDTO cadastrar(CurriculoDTO dto) {
        Curriculo entity = this.mapper.toCurriculo(dto);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Curriculo cadastrado com ID " + entity.getCodigo())
                .build();
    }

    public CurriculoDTO consultarPeloCodigo(Long codigo) throws RegisterNotFoundException {
        Curriculo entity = this.repository.findById(codigo)
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
        return this.mapper.toCurriculoDTO(entity);
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