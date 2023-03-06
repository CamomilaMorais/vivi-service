package ifce.viviservice.repository;

import ifce.viviservice.entity.Autenticacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutenticacaoRepository extends JpaRepository<Autenticacao, String> {

}