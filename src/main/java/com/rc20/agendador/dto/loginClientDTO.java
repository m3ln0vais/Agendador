package com.rc20.agendador.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Desenv. 02
 */
@Getter
@Setter
public class loginClientDTO {
    private String email;
    private String password;
    private Boolean remember;
}