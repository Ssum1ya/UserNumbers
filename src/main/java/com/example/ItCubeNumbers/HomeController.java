package com.example.ItCubeNumbers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final UserNumberService userNumberService;

    public HomeController(UserNumberService userNumberService) {
        this.userNumberService = userNumberService;
    }

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("userNumbers", userNumberService.findAllUserNumbers());
        model.addAttribute("userNumber", new UserNumber());
        return "number-list.html";
    }
}
