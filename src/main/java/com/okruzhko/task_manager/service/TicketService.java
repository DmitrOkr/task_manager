package com.okruzhko.task_manager.service;

import com.okruzhko.task_manager.model.Ticket;
import com.okruzhko.task_manager.model.User;
import com.okruzhko.task_manager.repos.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket findById(Long id) {
        return ticketRepository.getOne(id);
    }


    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);

    }

}
