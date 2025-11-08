package com.example.ItCubeNumbers;

import com.example.ItCubeNumbers.user_number.UserNumber;
import com.example.ItCubeNumbers.user_number.UserNumberService;
import com.example.ItCubeNumbers.users.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {

    private final UserNumberService userNumberService;

    public HomeController(UserNumberService userNumberService) {
        this.userNumberService = userNumberService;
    }

    @GetMapping
    public String getRedirectHome() {
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String getHome(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("userNumbers", userNumberService.findAllByUser(user));
        model.addAttribute("userNumber", new UserNumber());
        return "number-list.html";
    }
}
