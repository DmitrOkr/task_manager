package com.okruzhko.task_manager.repos;

import com.okruzhko.task_manager.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepos extends CrudRepository <Ticket,Long>{

  List<Ticket> findById(long id);
  List<Ticket> findAllById(Long id);
}
