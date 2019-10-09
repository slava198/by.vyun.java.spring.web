package by.itstep.controller;


import by.itstep.model.RegistrationException;
import by.itstep.model.User;
import by.itstep.model.dto.UserDto;
import by.itstep.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/reg")
    public String reg(UserDto registration, RedirectAttributes attributes) {
        try {
            userService.registration(registration);
        }
        catch (RegistrationException ex) {
            attributes.addAttribute("error", ex.getMessage());
            //ex.printStackTrace();
        }
        return "redirect:/?login=" + registration.getLogin();

    }

    @GetMapping("/del")
    public String del(String login, HttpSession httpSession) {
        userService.delUserByLogin(login);
        String currentLogin = (String) httpSession.getAttribute("login");
        if (login.equals(currentLogin)) {
            return "redirect:/out";
        }
        return "redirect:/?login=" + login;

    }

    @PostMapping("/auth")
    public String auth(UserDto userData, HttpSession session) {
        User user = userService.auth(userData);
        if (userService.auth(userData) != null) {
            session.setAttribute("login", user.getLogin());
        }

        return "redirect:";
    }

    @GetMapping("/out")
    public String out(HttpSession session) {
        session.removeAttribute("login");
        return "redirect:";
    }




}
