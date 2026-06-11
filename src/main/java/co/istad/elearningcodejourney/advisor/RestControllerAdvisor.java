package co.istad.elearningcodejourney.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestControllerAdvisor {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse<?>> handleResponseStatusException(
            ResponseStatusException e
    ){
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .message(e.getMessage())
                        .status(e.getStatusCode().value())
                        .timestamp(LocalDateTime.now())
                        .build()
                , e.getStatusCode()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<?>> handleValidationException(
            MethodArgumentNotValidException e
    ){
        Map<String,String > errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(),error.getDefaultMessage())
        );
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .message("Provide data is invalid")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .errors(errors)
                        .timestamp(LocalDateTime.now())
                        .build()
                , HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse<?>> handleGeneralException(Exception e){
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .message("Something went wrong: "+ e.getMessage())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .timestamp(LocalDateTime.now())
                        .build()
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
