package ifce.viviservice.controller;

import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.service.AutenticacaoService;
import ifce.viviservice.service.dto.AutenticacaoDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auths")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroDTO cadastrar(@RequestBody @Valid AutenticacaoDTO dto) {
        return this.service.cadastrar(dto);
    }

    @GetMapping("/{codigo}")
    public AutenticacaoDTO consultarPeloCodigo(@PathVariable("codigo") Long codigo) throws RegisterNotFoundException {
        return this.service.consultarPeloCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("codigo") Long codigo) throws RegisterNotFoundException {
        this.service.remover(codigo);
    }

}