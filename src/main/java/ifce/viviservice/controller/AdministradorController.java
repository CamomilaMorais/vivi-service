package ifce.viviservice.controller;

import ifce.viviservice.service.AdministradorService;
import ifce.viviservice.service.dto.AdministradorDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService service;

    public CadastroDTO create(AdministradorDTO dto) {
        return this.service.create(dto);
    }

}