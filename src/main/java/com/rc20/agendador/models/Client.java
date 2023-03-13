package com.rc20.agendador.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Desenv. 02
 */
@Getter
@Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Person person;
    private LocalDateTime lastSchedule;
    @OneToOne(cascade = CascadeType.ALL)
    private Work lastWork;
    private String password;
}
