package ifce.viviservice.repository;

import ifce.viviservice.entity.Dominio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DominioRepository extends JpaRepository<Dominio, String> {

    Optional<Dominio> findByCodigoAndValor(String codigo, String valor);

}