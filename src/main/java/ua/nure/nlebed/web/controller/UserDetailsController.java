package ua.nure.nlebed.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nure.nlebed.service.UserService;
import ua.nure.nlebed.web.Navigation;
import ua.nure.nlebed.web.Section;

import java.security.Principal;

@Controller
@Navigation(Section.USERDETAILS)
public class UserDetailsController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userDetails")
    public String userDetails(Model model, Principal principal) {
        model.addAttribute("principal", principal.getName());
        userService.findUserByEmail(principal.getName());
        return "userdetails/index";
    }

    @RequestMapping("/userDetails/{email}")
    public String clientDetails(Model model, @PathVariable String email) {
        model.addAttribute("principal", email);
        userService.findUserByEmail(email);
        return "userdetails/index";
    }


}