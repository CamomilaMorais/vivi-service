package ifce.viviservice.controller;

import ifce.viviservice.service.AdministradorService;
import ifce.viviservice.service.CampusService;
import ifce.viviservice.service.dto.AdministradorDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.dto.CampusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/campi")
public class CampusController {

    @Autowired
    private CampusService service;

    @PostMapping
    public CadastroDTO create(@RequestBody @Valid CampusDTO dto) {
        return this.service.create(dto);
    }

}