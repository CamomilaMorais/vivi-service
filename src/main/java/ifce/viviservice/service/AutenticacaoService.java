package ifce.viviservice.service;

import ifce.viviservice.entity.Autenticacao;
import ifce.viviservice.exception.RegisterNotFoundException;
import ifce.viviservice.repository.AutenticacaoRepository;
import ifce.viviservice.service.dto.AutenticacaoDTO;
import ifce.viviservice.service.dto.CadastroDTO;
import ifce.viviservice.service.mapper.AutenticacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private AutenticacaoRepository repository;
    @Autowired
    private AutenticacaoMapper mapper;

    public CadastroDTO cadastrar(AutenticacaoDTO dto) {
        Autenticacao entity = this.mapper.toAutenticacao(dto);
        entity.setDataInclusao(LocalDateTime.now());
        entity = this.repository.save(entity);
        return CadastroDTO
                .builder()
                .mensagem("Autenticacao cadastrada com ID " + entity.getCodigo())
                .build();
    }

    public AutenticacaoDTO consultarPeloCodigo(Long codigo) throws RegisterNotFoundException {
        Autenticacao entity = this.repository.findById(codigo)
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
        return this.mapper.toAutenticacaoDTO(entity);
    }

    public void remover(Long codigo) throws RegisterNotFoundException {
        this.repository
                .findById(codigo)
                .map(entity -> {
                    this.repository.delete(entity);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new RegisterNotFoundException(codigo));
    }

    public void atualizar(Long codigo, AutenticacaoDTO dto) throws RegisterNotFoundException {
        Autenticacao entity = this.repository.findById(codigo).orElseThrow(() -> new RegisterNotFoundException(codigo));
        LocalDateTime dataInclusao = entity.getDataInclusao();
        entity = this.mapper.toAutenticacao(dto);
        entity.setCodigo(codigo);
        entity.setDataInclusao(dataInclusao);
        entity.setDataAlteracao(LocalDateTime.now());
        this.repository.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Autenticacao auth = this.repository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado"));

        return User.builder()
                .username(username)
                .password(auth.getSenha())
                .roles(auth.getPerfil())
                .build();
    }

}