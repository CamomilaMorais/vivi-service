package ifce.viviservice.service.mapper;

import ifce.viviservice.entity.Aluno;
import ifce.viviservice.service.dto.AlunoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    @Autowired
    private ModelMapper mapper;

    public Aluno toAluno(AlunoDTO dto) {
        return this.mapper.map(dto, Aluno.class);
    }

    public AlunoDTO toAlunoDTO(Aluno entity) {
        return this.mapper.map(entity, AlunoDTO.class);
    }

}