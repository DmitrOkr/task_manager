package com.okruzhko.task_manager.repos;

import com.okruzhko.task_manager.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import com.okruzhko.task_manager.model.User;

import java.util.List;

public interface UserRepos extends JpaRepository<User, Long> {
        User findByUsername(String username);
       User findAllById(Long id);
        }