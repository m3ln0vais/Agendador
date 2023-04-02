package com.rc20.agendador.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rc20.agendador.enuns.Themes;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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

    @Size(min = 3, message = "O minimo é de 3 letras.")
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
    @Lob
    private byte[] img;

    @JsonIgnore
    public String getImgBase64() {
        return new String(img);
    }

    public Store(Long id) {
        this.id = id;
    }

    public Store() {
    }
}
