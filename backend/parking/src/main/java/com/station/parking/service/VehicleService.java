package com.station.parking.service;

import com.station.parking.modal.Vehicle;
import com.station.parking.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserService userService;

    public List<Vehicle> listar() {
        return vehicleRepository.findAll();
    }

    public Vehicle salvar(Vehicle vehicle) {
        userService.buscarPorId(vehicle.getUser().getId());
        return vehicleRepository.save(vehicle);
    }

}
