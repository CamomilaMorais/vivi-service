package ifce.viviservice.controller;

import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.service.CurriculoService;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.CurriculoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroDTO cadastrar(@RequestBody @Valid CurriculoDTO dto) {
        return this.service.cadastrar(dto);
    }

    @GetMapping("/{codigo}")
    public CurriculoDTO consultarPeloCodigo(@PathVariable("codigo") Long codigo) throws RegisterNotFoundException {
        return this.service.consultarPeloCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("codigo") Long codigo) throws RegisterNotFoundException {
        this.service.remover(codigo);
    }

}