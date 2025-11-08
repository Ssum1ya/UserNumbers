package com.example.ItCubeNumbers.user_number;

import com.example.ItCubeNumbers.users.User;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/userNumber")
public class UserNumberController {

    private final UserNumberService userNumberService;

    public UserNumberController(UserNumberService userNumberService) {
        this.userNumberService = userNumberService;
    }

    @GetMapping("/select")
    public String selectNumbers(@AuthenticationPrincipal User user, @ModelAttribute("userNumber") UserNumber userNumber, Model model) {
        model.addAttribute("userNumbers", userNumberService.findUserNumbersSort(user, userNumber));
        return "number-list.html";
    }

    @PostMapping("/add")
    public String addNumber(@AuthenticationPrincipal User user, @ModelAttribute("userNumber") @Valid UserNumber userNumber, Errors errors) {
        if (errors.hasErrors()) {
            return "userNumber-form.html";
        }
        userNumber.setUser(user);
        userNumberService.addUserNumber(userNumber);
        return "redirect:/home";
    }

    @GetMapping("/addPage")
    public String updatePage(Model model) {
        model.addAttribute("userNumber", new UserNumber());
        return "userNumber-form.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteNumber(@PathVariable Long id) {
        userNumberService.deleteUserNumber(id);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        UserNumber userNumber = userNumberService.findUserNumberById(id);
        model.addAttribute("userNumber", userNumber);
        return "userNumber-form.html";
    }
}