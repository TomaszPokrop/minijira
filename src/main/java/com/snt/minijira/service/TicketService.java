package com.snt.minijira.service;

import com.snt.minijira.exception.StatusNotFoundExeption;
import com.snt.minijira.model.Ticket;
import com.snt.minijira.model.User;
import com.snt.minijira.repository.TicketRepository;
import com.snt.minijira.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TicketService {
    private final TicketRepository ticketRepo;
    private final UserRepository userRepository;
    private final UserService userService;


    @Autowired
    public TicketService(TicketRepository ticketRepo, UserRepository userRepository, UserService userService) {
        this.ticketRepo = ticketRepo;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public Ticket addTicket(Ticket ticket) {
        ticket.setUser(userService.getLoggedUser());
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
