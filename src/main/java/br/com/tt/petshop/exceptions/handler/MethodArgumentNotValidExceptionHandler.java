package br.com.tt.petshop.exceptions.handler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ApiError>> handle(MethodArgumentNotValidException e){
        List<ApiError> erros =  e.getBindingResult().getFieldErrors()
                            .stream().map(f -> new ApiError(f.getField(), f.getDefaultMessage()))
                            .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(erros);
    }
}