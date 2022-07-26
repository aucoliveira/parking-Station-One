package com.station.parking.handler;

import com.station.parking.modal.DetalhesErro;
import com.station.parking.service.exceptions.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handlerUsuarioNaoEncontradoException
            (UsuarioNaoEncontradoException e, HttpServletRequest request) {

        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(400l);
        erro.setTitulo("Usuário não encontrado");
        erro.setMensagemDesenvolvedor("http://packing.com/400");
        erro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }


}
