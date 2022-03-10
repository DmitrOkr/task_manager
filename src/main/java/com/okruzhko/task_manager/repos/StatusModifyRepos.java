package com.okruzhko.task_manager.repos;

import com.okruzhko.task_manager.model.Status;
import com.okruzhko.task_manager.model.Ticket;
import com.okruzhko.task_manager.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StatusModifyRepos extends CrudRepository<Ticket,Long> {
    @Modifying
    @Query("update Ticket t set  t.date = ?1, t.message = ?2, t.author = ?3, t.status = ?4 where t.id = ?5")
    List<Ticket>  statusModify(Date date, User user , String message, Status status, Long id);

}
