package com.alaythiaproductions.bookstoreadmin.controlelrs;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "views/home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "views/login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        return "views/logout";
    }
}
