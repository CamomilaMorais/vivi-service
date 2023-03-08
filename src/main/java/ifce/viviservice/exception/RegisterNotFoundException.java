package ifce.viviservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegisterNotFoundException extends Exception {

    public RegisterNotFoundException(Long codigo) {
        super("Registro com ID " + codigo + " não encontrado");
    }

    public RegisterNotFoundException(String codigo, String valor) {
        super("Registro com ID " + codigo + " e " + valor + " não encontrado");
    }

    public RegisterNotFoundException(String codigo) {
        super("Registro com ID " + codigo + " não encontrado");
    }

}
