package com.linfilter.controllers;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FacebookController {
    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    public String linkedInView(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        String[] fields = {"id", "first_name", "last_name"};
        User user = facebook.fetchObject("me", User.class, fields);
        model.addAttribute("id", user.getId());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());

        model.addAttribute("feed", facebook.feedOperations().getFeed());
        return "index";
    }
}
