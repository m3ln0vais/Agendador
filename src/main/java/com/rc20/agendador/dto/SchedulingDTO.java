package com.rc20.agendador.dto;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author Desenv. 02
 */

@Data
public class SchedulingDTO {

    private Long id;
    private Long client;
    private Long work;
    private Long employee;
    private LocalDateTime schedulingTo;
}
