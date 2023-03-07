package ifce.viviservice.controller;

import ifce.viviservice.service.DominioService;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.DominioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/dominios")
public class DominioController {

    @Autowired
    private DominioService service;

    @PostMapping
    public CadastroDTO create(@RequestBody @Valid DominioDTO dto) {
        return this.service.create(dto);
    }

}