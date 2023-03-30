package com.rc20.agendador.dto;

import com.rc20.agendador.enuns.Themes;
import com.rc20.agendador.models.Address;
import com.rc20.agendador.models.Contact;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Desenv. 02
 */
@Data
public class RegisterDTO {

    @Size(min = 3, message = "O minimo é de 3 letras.")
    @NotNull(message = "nome não pode ser nulo")
    @NotBlank(message = "não pode estar branco")
    private String name;

    @Enumerated(EnumType.STRING)
    private Themes theme;

    @Email(message = "Email inválido")
    private String email;

    private String password;
}
