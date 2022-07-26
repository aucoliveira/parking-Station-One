package com.station.parking.service;

import com.station.parking.modal.User;
import com.station.parking.modal.Vehicle;
import com.station.parking.repository.UserRepository;
import com.station.parking.repository.VehicleRepository;
import com.station.parking.service.dto.UserDto;
import com.station.parking.service.dto.VehicleListDto;
import com.station.parking.service.exceptions.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<User> listar() {

        return userRepository.findAll();
    }

    public User salvar(User user) {
        return userRepository.save(user);
    }

    public User buscarPorId(Long id) {
        User usuario = userRepository.findById(id).orElse(null);

        if (usuario == null) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
        }
        return usuario;
    }

    public List<VehicleListDto> listarVeiculos(Long id) {
        User users = buscarPorId(id);
        List<Vehicle> veiculos = users.getVehicle();
        return veiculos.stream()
                .map(this::mostraVehicle)
                .collect(Collectors.toList());
    }

    public VehicleListDto mostraVehicle(Vehicle vehicle) {
        VehicleListDto veiculos = new VehicleListDto();
        veiculos.setId(vehicle.getId());
        veiculos.setMarca(vehicle.getMarca());
        veiculos.setModelo(vehicle.getModelo());
        veiculos.setAno(vehicle.getAno());
        return veiculos;
    }
}
