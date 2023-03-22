/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rc20.agendador.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Desenv. 02
 */
@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cep;
    @Size(min = 3, message = "O minimo é de 3 letras.")
    private String road;
    @Size(min = 3, message = "O minimo é de 3 letras.")
    private String district;
    @Size(min = 2, message = "O minimo é de 2 letras.")
    private String state;
    private String number;
}
