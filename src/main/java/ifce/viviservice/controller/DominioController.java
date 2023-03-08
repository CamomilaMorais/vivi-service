package ifce.viviservice.controller;

import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.service.DominioService;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.DominioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dominios")
public class DominioController {

    @Autowired
    private DominioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroDTO cadastrar(@RequestBody @Valid DominioDTO dto) {
        return this.service.cadastrar(dto);
    }

    @GetMapping("/{codigo}")
    public List<DominioDTO> consultarPeloCodigo(@PathVariable("codigo") String codigo) {
        return this.service.consultarPeloCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("codigo") String codigo) throws RegisterNotFoundException {
        this.service.remover(codigo);
    }

    @DeleteMapping("/{codigo}/{valor}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("codigo") String codigo, @PathVariable("valor") String valor) throws RegisterNotFoundException {
        this.service.remover(codigo, valor);
    }

    @PutMapping("/{codigo}/{valor}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable("codigo") String codigo, @PathVariable("valor") String valor, @RequestBody @Valid DominioDTO dto) throws RegisterNotFoundException {
        this.service.atualizar(codigo, valor, dto);
    }

    @PutMapping("/desativar/{codigo}/{valor}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desativar(@PathVariable("codigo") String codigo, @PathVariable("valor") String valor, @RequestParam("usuario") String usuario) throws RegisterNotFoundException {
        this.service.desativar(codigo, valor, usuario);
    }

}