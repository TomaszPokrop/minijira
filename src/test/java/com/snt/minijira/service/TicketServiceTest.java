package com.snt.minijira.service;

import com.snt.minijira.enums.Difficulty;
import com.snt.minijira.enums.TimeConsuming;
import com.snt.minijira.model.Ticket;
import com.snt.minijira.repository.TicketRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {
    @Mock
    private TicketRepository ticketRepository;

    private TicketService underTest;

    @BeforeEach
    void setUp() {

        underTest = new TicketService(ticketRepository);
    }

    @Test
    void canAddTicket() {
//        given
        Ticket ticket = new Ticket(1L, "1", "1", "1", "1", "1", "1", TimeConsuming.LONG, Difficulty.EASY);
//        when
        underTest.addTicket(ticket);
//        then
        ArgumentCaptor<Ticket> ticketArgumentCaptor = ArgumentCaptor.forClass(Ticket.class);
        verify(ticketRepository).save(ticketArgumentCaptor.capture());

        Ticket capturedTicket = ticketArgumentCaptor.getValue();
        assertThat(capturedTicket).isEqualTo(ticket);
    }

    @Test
    void canFindAllTickets() {
//        when
        underTest.findAllTickets();
//        then
        verify(ticketRepository).findAll();
    }

    @Test
    void canFindTicketById() {
//        given

//        when
         ticketRepository.findById(1L);
//        then

            verify(ticketRepository).findById(eq(1L));

    }

    @Test
    void canUpdateTicket() {
//        given
        Ticket ticket = new Ticket(1L, "1", "1", "1", "1", "1", "1", TimeConsuming.LONG, Difficulty.EASY);
//        when
        underTest.updateTicket(ticket);
          ArgumentCaptor<Ticket> ticketArgumentCaptor = ArgumentCaptor.forClass(Ticket.class);
          verify(ticketRepository).save(ticketArgumentCaptor.capture());

           Ticket capturedTicket = ticketArgumentCaptor.getValue();
           assertThat(capturedTicket).isEqualTo(ticket);
    }

    @Test
    @Disabled
    void shouldDeleteTicket() {
 //        given
        Ticket ticket = new Ticket(1L, "1", "1", "1", "1", "1", "1", TimeConsuming.LONG, Difficulty.EASY);
//        underTest.addTicket(ticket);
//        when
        underTest.deleteTicket(ticket.getId());
        ArgumentCaptor<Ticket> ticketArgumentCaptor = ArgumentCaptor.forClass(Ticket.class);
        verify(ticketRepository).delete(ticketArgumentCaptor.capture());

        Ticket capturedTicket = ticketArgumentCaptor.getValue();
        assertThat(capturedTicket).isEqualTo(ticket);
    }
}