package com.station.parking.service.dto;

import com.station.parking.modal.User;
import com.station.parking.modal.Vehicle;

public class VehicleDto {

    private String marca;
    private String modelo;
    private String ano;
    private User user;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }


    public Vehicle converter() {
        Vehicle veiculo = new Vehicle();

        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setAno(ano);
        veiculo.setUser(user);

        return veiculo;
    }
}
