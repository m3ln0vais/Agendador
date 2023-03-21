package com.rc20.agendador.models;

import com.rc20.agendador.enuns.Themes;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 8, message = "min 3 e max 8")
    @NotNull(message = "nome não pode ser nulo")
    @NotBlank(message = "não pode estar branco")
    private String name;

    private String slogan;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Enumerated(EnumType.STRING)
    private Themes theme;
    
    private String email;
    
    private String password;
    @Transient
    private Boolean remember;

}
