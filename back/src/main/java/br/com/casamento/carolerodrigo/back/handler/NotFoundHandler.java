package br.com.casamento.carolerodrigo.back.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class NotFoundHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NoResourceFoundException.class)
    public String handleNoHandlerFoundException(NoResourceFoundException ex) {
        return "forward:/index.html";
    }

}
