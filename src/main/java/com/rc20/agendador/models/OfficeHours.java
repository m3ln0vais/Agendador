package com.rc20.agendador.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Desenv. 02
 */
@Entity
@Getter
@Setter
public class OfficeHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "nome não pode ser nulo")
    private LocalTime entryTime; //horário de entrada
    @NotNull(message = "nome não pode ser nulo")
    private LocalTime lunchTime; //horário de almoço
    @NotNull(message = "nome não pode ser nulo")
    private LocalTime departureTime; //horário de saida
}
