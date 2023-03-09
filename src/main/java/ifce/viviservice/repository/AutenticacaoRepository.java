package ifce.viviservice.repository;

import ifce.viviservice.entity.Autenticacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutenticacaoRepository extends JpaRepository<Autenticacao, Long> {

    Optional<Autenticacao> findByUsuario(String usuario);

}