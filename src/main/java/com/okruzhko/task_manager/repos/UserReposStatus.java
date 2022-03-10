package com.okruzhko.task_manager.repos;

import com.okruzhko.task_manager.model.Status;
import com.okruzhko.task_manager.model.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserReposStatus extends CrudRepository<Ticket, Long> {
    @Modifying
    @Query("update Ticket c set c.status = :status WHERE c.id = :status_id")
    void setCustomerName(@Param("status_id") Long status_id, @Param("status") Status status);

}
