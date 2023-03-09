/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rc20.agendador.enuns;

import static java.util.Arrays.asList;
import java.util.Objects;

/**
 *
 * @author Desenv. 02
 */
public enum EmployeeStatus {
    ACTIVE(1, "Ativo"),
    DISABLED(2, "Desativado"),
    ATTENDANCE(3, "Atendendo");

    private Integer id;
    private String status;

    private EmployeeStatus(Integer id, String name) {
        this.id = id;
        this.status = name;
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public static EmployeeStatus get(Integer id) {
        return asList(values())
                .stream()
                .filter(x -> Objects.equals(x.id, id))
                .findFirst()
                .get();
    }
}
