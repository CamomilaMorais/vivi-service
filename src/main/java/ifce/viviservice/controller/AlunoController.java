package ifce.viviservice.controller;

import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.service.AlunoService;
import ifce.viviservice.service.dto.AlunoDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroDTO cadastrar(@RequestBody @Valid AlunoDTO dto) {
        return this.service.cadastrar(dto);
    }

    @GetMapping("/{codigo}")
    public AlunoDTO consultarPeloCodigo(@PathVariable("codigo") Long codigo) throws RegisterNotFoundException {
        return this.service.consultarPeloCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("codigo") Long codigo) throws RegisterNotFoundException {
        this.service.remover(codigo);
    }

}