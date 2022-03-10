package com.okruzhko.task_manager.service;

import com.okruzhko.task_manager.model.Ticket;
import com.okruzhko.task_manager.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class TicketAuthorNameService  implements UserDetailsService {
    @Autowired
    private UserRepos userRepos;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserByIDetails(Long id)  {
        return userRepos.findAllById(id);
    }
}
