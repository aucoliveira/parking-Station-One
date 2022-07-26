package com.station.parking.service.dto;

import com.station.parking.modal.User;
import com.station.parking.modal.Vehicle;

public class VehicleListDto {

    private Long id;
    private String marca;
    private String modelo;
    private String ano;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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


}
