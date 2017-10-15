package br.com.usuario.handler;

import br.com.usuario.exception.CampanhaNotFoundException;
import br.com.usuario.response.ErrorMessage;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        ErrorMessage errorMessage = new ErrorMessage(errors);
        return handleExceptionInternal(ex, errorMessage, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Object message = "";
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException exception = (InvalidFormatException) ex.getCause();
            message = exception.getValue();
        }

        ex.printStackTrace();
        ErrorMessage errorMessage = new ErrorMessage("Verifique o contrato de envio, não foi possível fazer a " +
                "conversão do valor " + message);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CampanhaNotFoundException.class)
    public ResponseEntity<Object> handleCampanhaNotFoundException(CampanhaNotFoundException ex) {
        ErrorMessage errorMessage = ex.getErrorMessage();
        ex.printStackTrace();
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage("Ocorreu um erro ao cadastrar o usuário, tente novamente !");
        ex.printStackTrace();
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
