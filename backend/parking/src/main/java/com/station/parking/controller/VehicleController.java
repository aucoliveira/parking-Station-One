package com.station.parking.controller;

import com.station.parking.modal.Vehicle;
import com.station.parking.service.VehicleService;
import com.station.parking.service.dto.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> listar() {

        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.listar());
    }

    @PostMapping(value = "salvar")
    public ResponseEntity<Vehicle> salvar(@RequestBody VehicleDto vehicle) {

        Vehicle veiculo = vehicleService.salvar(vehicle.converter());

        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }
}
