package com.okruzhko.task_manager.repos;

import com.okruzhko.task_manager.model.Ticket;
import com.okruzhko.task_manager.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminTicketRepos extends CrudRepository<User,Long> {
    @Query("select t from Ticket t where t.id = :id")
    List<Ticket> findTicketAdmin(@Param("id") Long id);
}
