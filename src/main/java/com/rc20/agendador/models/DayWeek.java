package com.rc20.agendador.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Desenv. 02
 */
@Getter
@Setter
@Entity
public class DayWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2)
    private String sunday;
    @Column(length = 2)
    private String monday;
    @Column(length = 2)
    private String tuesday;
    @Column(length = 2)
    private String wednesday;
    @Column(length = 2)
    private String thursday;
    @Column(length = 2)
    private String friday;
    @Column(length = 2)
    private String saturday;
    
}
