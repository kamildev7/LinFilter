package com.linfilter.controllers;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class LinkedInController {
    private LinkedIn linkedIn;
    private ConnectionRepository connectionRepository;

    public LinkedInController(LinkedIn linkedIn, ConnectionRepository connectionRepository) {
        this.linkedIn = linkedIn;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    public String linkedInView(Model model) {
        if (connectionRepository.findPrimaryConnection(LinkedIn.class) == null) {
            return "redirect:/connect/linkedin";
        }

        model.addAttribute("linkedinProfile", linkedIn.profileOperations().getUserProfile());
        return "index";
    }
}
