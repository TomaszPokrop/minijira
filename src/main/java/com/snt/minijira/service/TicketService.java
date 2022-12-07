package com.snt.minijira.service;

import com.snt.minijira.exception.StatusNotFoundExeption;
import com.snt.minijira.model.Ticket;
import com.snt.minijira.model.User;
import com.snt.minijira.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepo;

    @Autowired
    public TicketService(TicketRepository ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    public List<Ticket> findAllTickets() {
        return ticketRepo.findAll();
    }

    public Ticket findTicketById(Long id) {
        return ticketRepo.findById(id).orElseThrow(() -> new StatusNotFoundExeption("Ticket by status" + id + "was not found"));
    }


    public Ticket updateTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepo.deleteTicketById(id);

    }

}
