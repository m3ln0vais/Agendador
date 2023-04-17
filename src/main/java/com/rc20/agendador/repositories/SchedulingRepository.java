package com.rc20.agendador.repositories;

import com.rc20.agendador.models.Client;
import com.rc20.agendador.models.Scheduling;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Desenv. 02
 */
@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long>  {
    List<Scheduling> findByClient(Client client);
}
