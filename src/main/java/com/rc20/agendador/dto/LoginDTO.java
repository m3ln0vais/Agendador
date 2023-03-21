package com.rc20.agendador.dto;

import lombok.Data;

/**
 *
 * @author Desenv. 02
 */

@Data
public class LoginDTO {
    private String email;
    private String password;
    private Boolean remember;
}
