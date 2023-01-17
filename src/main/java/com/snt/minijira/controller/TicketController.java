package com.snt.minijira.controller;

import com.snt.minijira.model.Ticket;
import com.snt.minijira.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.findAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id) {
        Ticket ticket = ticketService.findTicketById(id);
        return ResponseEntity.ok(ticket);
    }


    @PostMapping
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        Ticket newTicket = ticketService.addTicket(ticket);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        Ticket updatedTicket = ticketService.updateTicket(ticket);
        return ResponseEntity.ok(updatedTicket);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok().build();
    }
}
