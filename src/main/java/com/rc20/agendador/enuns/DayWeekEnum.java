package com.rc20.agendador.enuns;

import static java.util.Arrays.asList;
import java.util.Objects;

/**
 *
 * @author mel
 */
public enum DayWeekEnum {
    DOMINGO(1, "Domingo"),
    SEGUNDA(2, "Segunda-Feira"),
    TERCA(3, "Terça-Feira"),
    QUARTA(4, "Quarta-Feira"),
    QUINTA(5, "Quinta-Feira"),
    SEXTA(6, "Sexta-Feira"),
    SABADO(7, "Sabado");

    private Integer id;
    private String dayWeek;

    private DayWeekEnum(Integer id, String name) {
        this.id = id;
        this.dayWeek = name;
    }

    public Integer getId() {
        return id;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public static DayWeekEnum get(Integer id) {
        return asList(values())
                .stream()
                .filter(x -> Objects.equals(x.id, id))
                .findFirst()
                .get();
    }
}
