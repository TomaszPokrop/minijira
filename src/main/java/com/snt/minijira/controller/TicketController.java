package com.snt.minijira.controller;

import com.snt.minijira.model.Ticket;
import com.snt.minijira.model.User;
import com.snt.minijira.repository.UserRepository;
import com.snt.minijira.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;
    private final UserRepository userRepository;

    public TicketController(TicketService ticketService, UserRepository userRepository) {
        this.ticketService = ticketService;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.findAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id) {
        Ticket ticket = ticketService.findTicketById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        User loggedUser = userRepository.findAll().stream().findFirst().get();
        ticket.setUser(loggedUser);
        Ticket newTicket = ticketService.addTicket(ticket);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        Ticket updatedTicket = ticketService.updateTicket(ticket);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
