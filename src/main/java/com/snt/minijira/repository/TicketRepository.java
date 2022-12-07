package com.snt.minijira.repository;

import com.snt.minijira.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TicketRepository extends JpaRepository<Ticket, Long> {
    void deleteTicketById(Long id);

}
