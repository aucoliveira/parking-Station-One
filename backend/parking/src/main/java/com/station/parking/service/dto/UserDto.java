package com.station.parking.service.dto;

import com.station.parking.modal.User;
import com.station.parking.modal.Vehicle;

import java.util.List;

public class UserDto {

    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;
    private List<Vehicle> vehicle;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public User converter() {

        User user = new User();

        user.setNome(nome);
        user.setEmail(email);
        user.setCpf(cpf);
        user.setDataNascimento(dataNascimento);
        user.setVehicle(vehicle);
        return user;
    }
}
