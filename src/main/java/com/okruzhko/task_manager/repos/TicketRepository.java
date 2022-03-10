package com.okruzhko.task_manager.repos;

import com.okruzhko.task_manager.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
