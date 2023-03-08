package ifce.viviservice.controller;

import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.service.CursoService;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.CursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroDTO cadastrar(@RequestBody @Valid CursoDTO dto) {
        return this.service.cadastrar(dto);
    }

    @GetMapping("/{codigo}")
    public CursoDTO consultarPeloCodigo(@PathVariable("codigo") Long codigo) throws RegisterNotFoundException {
        return this.service.consultarPeloCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("codigo") Long codigo) throws RegisterNotFoundException {
        this.service.remover(codigo);
    }

}