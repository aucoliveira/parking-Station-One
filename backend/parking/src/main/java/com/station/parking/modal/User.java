package com.station.parking.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "users") // user é uma palavra reservada no postgresql
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String dataNascimento;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Vehicle> vehicle;

    public User() {}

    public User(Long id, String nome, String email, String cpf, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
