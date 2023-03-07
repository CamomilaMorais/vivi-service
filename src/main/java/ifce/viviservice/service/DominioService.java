package ifce.viviservice.service;

import ifce.viviservice.entity.Dominio;
import ifce.viviservice.repository.DominioRepository;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.DominioDTO;
import ifce.viviservice.service.mapper.DominioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DominioService {

    @Autowired
    private DominioRepository repository;
    @Autowired
    private DominioMapper mapper;

    public CadastroDTO create(DominioDTO dto) {
        Dominio entity = this.mapper.toCampus(dto);
        entity.setStatus(1);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Dominio criado com ID " + entity.getCodigo())
                .build();
    }

}