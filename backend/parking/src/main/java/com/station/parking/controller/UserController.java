package com.station.parking.controller;

import com.station.parking.modal.User;
import com.station.parking.modal.Vehicle;
import com.station.parking.service.UserService;
import com.station.parking.service.dto.UserDto;
import com.station.parking.service.dto.VehicleListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listar() {
        return  ResponseEntity.status(HttpStatus.OK).body(userService.listar());
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<User> salvar(@RequestBody UserDto userDto) {
        User usuario = userService.salvar(userDto.converter());
        return new ResponseEntity<User>(usuario, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}/veiculos")
    public ResponseEntity<?> buscaVeiculoUser(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listarVeiculos(id));
    }

}
