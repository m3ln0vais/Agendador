package com.rc20.agendador.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Desenv. 02
 */

@Getter
@Setter
@Entity
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 8, message = "min 3 e max 8")
    @NotNull(message = "nome não pode ser nulo")
    @NotBlank(message = "não pode estar branco")   
    private String name;
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    private Integer timeStart;
    private Integer timeInterval;
    private Integer timeFinish;
}
