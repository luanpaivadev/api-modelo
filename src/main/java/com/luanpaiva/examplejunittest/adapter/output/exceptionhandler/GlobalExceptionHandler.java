package com.luanpaiva.examplejunittest.adapter.output.exceptionhandler;

import com.luanpaiva.examplejunittest.adapter.model.dto.ErrorResponse;
import com.luanpaiva.examplejunittest.core.exceptions.BearerTokenException;
import com.luanpaiva.examplejunittest.core.exceptions.ClienteNaoEncontradoException;
import com.luanpaiva.examplejunittest.core.exceptions.ProdutoNaoEncontradoException;
import com.luanpaiva.examplejunittest.core.exceptions.TokenInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static java.text.MessageFormat.format;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String OS_ATRIBUTOS_NAO_DEVEM_SER_NULOS = "Os atributos {0}, não devem ser nulos.";
    private static final String O_ATRIBUTO_NAO_DEVE_SER_NULO = "O atributo {0}, não deve ser nulo.";

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception exception) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage()));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(ClienteNaoEncontradoException exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(ProdutoNaoEncontradoException exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(MethodArgumentNotValidException exception) {

        List<String> fields = new ArrayList<>();

        exception.getFieldErrors()
                .forEach(fieldError -> fields.add(fieldError.getField()));

        String message = (fields.size() > 1) ? format(OS_ATRIBUTOS_NAO_DEVEM_SER_NULOS, fields)
                : format(O_ATRIBUTO_NAO_DEVE_SER_NULO, fields);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(exception.getStatusCode().value(), message, exception.getMessage()));
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(BadCredentialsException exception) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ErrorResponse(HttpStatus.FORBIDDEN.value(), exception.getMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BearerTokenException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(BearerTokenException exception) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage()));
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(TokenInvalidoException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(TokenInvalidoException exception) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), exception.getMessage()));
    }
}
