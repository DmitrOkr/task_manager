package com.okruzhko.task_manager.controller;

import com.okruzhko.task_manager.model.Role;
import com.okruzhko.task_manager.model.Status;
import com.okruzhko.task_manager.model.Ticket;
import com.okruzhko.task_manager.model.User;
import com.okruzhko.task_manager.repos.*;
import com.okruzhko.task_manager.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.Date;
import java.util.Map;

@Controller

public class TaskManagerController {
    private UserDetailsService userDetailsService;
    private Role role;
    @Autowired
    private TicketRepos ticketRepos;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserReposStatus userReposStatus;
    @Autowired
    StatusModifyRepos statusModifyRepos;
    @Autowired
    private UserRepos userRepos;
    @Autowired
    private UserTicketRepos userTicketRepos;
    private User user;
    private Ticket ticket;
    //private Status status;
    public Object objectUser;

    @GetMapping("/")
    public String task(Map<String, Object> model) {
        return "task";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model, Authentication authentication, Role role) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Iterable<Ticket> tik = null;
        Iterable<Ticket> tikAdmin = null;
        //Iterable<Ticket> tickets = ticketRepos.findAll();
//        if(user.isAdmin()==true){
//            Iterable<Ticket> tikAdmin = userTicketRepos.findTicket(ticket.getAuthor().getUsername());
//            model.addAttribute("tickets", tikAdmin);
//        }
//        else {
        tikAdmin = ticketRepos.findAll();
        //tikAdmin = userTicketRepos.findTicket(ticket.getAuthor().getUsername());
        tik = userTicketRepos.findTicket(authentication.getName());
        if (filter != null && !filter.isEmpty()) {
            tik = ticketRepos.findById(Long.parseLong(filter));
        }
        if (filter != null && !filter.isEmpty()) {
            tikAdmin = ticketRepos.findById(Long.parseLong(filter));
        }

        objectUser = tik;
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("USER"));

        boolean hasUser = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));


        if (hasUserRole == true) {
            model.addAttribute("tickets", tik);
            model.addAttribute("filter", filter);

        }
        if (hasUser == true) {
            model.addAttribute("tickets", tikAdmin);

        }
        return "main";

    }

    public Object userN = null;

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String message, Status status, Map<String, Object> model) {
        Ticket ticket = new Ticket(new Date(), message, user, status);
        userN = user.getUsername();
        ticketRepos.save(ticket);
        Iterable<Ticket> tickets = ticketRepos.findAll();
        model.put("tickets", tickets);
        return "redirect:/main";
    }

    @GetMapping("/ticket-update/{id}")
    public String updateTicketForm(@PathVariable("id") Long id, Model model) {
        Ticket ticket = ticketService.findById(id);
        model.addAttribute("ticket", ticket);
        System.out.println(ticket.getId());
        System.out.println(userN);
        return "ticket-update";
    }

    @PostMapping("/ticket-update")
    public String updateTicket(Ticket ticket) {
        ticketService.saveTicket(ticket);
        System.out.println(userN);
        return "redirect:/main";
    }

}
