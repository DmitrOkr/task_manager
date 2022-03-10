package com.okruzhko.task_manager.repos;

import com.okruzhko.task_manager.model.Ticket;
import com.okruzhko.task_manager.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface UserTicketRepos extends CrudRepository<User,Long> {
@Query("select t from Ticket t where t.author.username = :author")
List<Ticket> findTicket(@Param("author") String author);
}


