package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//anotation para classe que trata erro
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)//404
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }
}
