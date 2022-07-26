package com.station.parking.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq_vehicle", sequenceName = "seq_vehicle", allocationSize = 1, initialValue = 1)
public class Vehicle implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vehicle")
    private Long id;

    private String marca;

    private String modelo;

    private String ano;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public Vehicle() {}

    public Vehicle(String marca, String modelo, String ano, User user) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.user = user;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
