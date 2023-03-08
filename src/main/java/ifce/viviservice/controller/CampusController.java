package ifce.viviservice.controller;

import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.service.CampusService;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.CampusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/campi")
public class CampusController {

    @Autowired
    private CampusService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroDTO cadastrar(@RequestBody @Valid CampusDTO dto) {
        return this.service.cadastrar(dto);
    }

    @GetMapping("/{codigo}")
    public CampusDTO consultarPeloCodigo(@PathVariable("codigo") Long codigo) throws RegisterNotFoundException {
        return this.service.consultarPeloCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("codigo") Long codigo) throws RegisterNotFoundException {
        this.service.remover(codigo);
    }

    @PutMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable("codigo") Long codigo, @RequestBody @Valid CampusDTO dto) throws RegisterNotFoundException {
        this.service.atualizar(codigo, dto);
    }

    @PutMapping("/desativar/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desativar(@PathVariable("codigo") Long codigo, @RequestParam("usuario") String usuario) throws RegisterNotFoundException {
        this.service.desativar(codigo, usuario);
    }

}