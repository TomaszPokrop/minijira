package com.snt.minijira.repository;

import com.snt.minijira.model.Ticket;
import com.snt.minijira.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    void deleteTicketById(Long id);


}
