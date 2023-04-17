package com.rc20.agendador.controllers;

import com.rc20.agendador.dto.SchedulingDTO;
import com.rc20.agendador.models.Client;
import com.rc20.agendador.models.Employee;
import com.rc20.agendador.models.Scheduling;
import com.rc20.agendador.models.Work;
import com.rc20.agendador.services.ClientService;
import com.rc20.agendador.services.EmployeeService;
import com.rc20.agendador.services.SchedulingService;
import com.rc20.agendador.services.WorkService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Desenv. 02
 */
@Controller
@RequestMapping("/scheduling-app")
public class SchedulingAppController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private SchedulingService schedulingService;

    @Autowired
    private WorkService workService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String main(Model model, Long id) {
        model.addAttribute("client", clientService.findById(id).get());
        return "views/clientApp/mainClient";
    }

    @GetMapping("/scheduling")
    public String scheduling(Model model, Long id) {
        model.addAttribute("client", clientService.findById(id).get());

        Client c = new Client();
        c.setId(id);
        model.addAttribute("schedules", schedulingService.findByClient(c));
        return "views/clientApp/scheduling";
    }

    @GetMapping("/schedule")
    public String scheduleForm(Model model, Optional<Long> s, Long id) throws IOException {

        model.addAttribute("client", clientService.findById(id).get());
        model.addAttribute("schedule", s.isPresent()
                ? schedulingService.findById(s.get()).get()
                : new Scheduling());

        model.addAttribute("listWork", workService.find());
        model.addAttribute("listEmployee", employeeService.find());

        return "views/clientApp/schedulingForm";
    }

    @PostMapping("/schedule")
    public String scheduleSave(Model model, SchedulingDTO dto) {
        model.addAttribute("client", clientService.findById(dto.getClient()).get());

        Scheduling s = new Scheduling();
        s.setId(dto.getId());

        Client client = new Client();
        client.setId(dto.getClient());
        s.setClient(client);

        Work work = new Work();
        work.setId(dto.getWork());
        s.setWork(work);

        s.setCreateAt(LocalDateTime.now());
        s.setSchedulingTo(dto.getSchedulingTo());

        Employee e = new Employee();
        e.setId(dto.getEmployee());
        s.setEmployee(e);

        schedulingService.save(s);
        return "redirect:/scheduling-app/scheduling?id=" + dto.getClient();
    }
}
