package com.rc20.agendador.models;

import com.rc20.agendador.enuns.DayWeekEnum;
import com.rc20.agendador.enuns.EmployeeStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Desenv. 02
 */

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Person person;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Work> works;
    @OneToMany(cascade = CascadeType.ALL)
    private List<DayWeek> daysWeek;
    @Enumerated(value = EnumType.STRING)
    private EmployeeStatus employeeStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private OfficeHours officeHours;
    
}
