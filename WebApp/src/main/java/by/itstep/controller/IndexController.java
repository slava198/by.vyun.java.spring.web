package by.itstep.controller;

import by.itstep.model.Cat;
import by.itstep.model.Dog;
import by.itstep.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    UserService userService;


    @ResponseBody
    @GetMapping("/params")
    public String hello() {
        return "Hi!!!";
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) String error, Model model, HttpSession httpSession) {

        String login = (String) httpSession.getAttribute("login");
        if (login != null) {
            model.addAttribute("login", login);
            model.addAttribute("users", userService.getAllUsers());
        }

        if (error != null) {
            model.addAttribute("error", error);
        }

        return "index";
    }



    @ResponseBody
    @GetMapping("/qwe")
    public String qwe() {
        return "1 + 1 = 2";
    }

    @ResponseBody
    @GetMapping("/calc")
    public String calc(@RequestParam( defaultValue = "0") Integer a, @RequestParam(defaultValue = "0") Integer b) {

        return String.valueOf(a + b);
    }

    @ResponseBody
    @GetMapping("/cat")
    public String cat (Cat cat) {

        return cat.toString();
    }

    @ResponseBody
    @GetMapping("/catcat")
    public Cat cat() {

        return new Cat(1, "Bob");
    }

    @ResponseBody
    @GetMapping("/catToDog")
    public Dog catToDog(Cat cat) {
        return new Dog(cat);

    }







}
