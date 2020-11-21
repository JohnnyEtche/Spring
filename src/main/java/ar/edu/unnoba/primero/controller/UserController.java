package ar.edu.unnoba.primero.controller;

import ar.edu.unnoba.primero.Modelo.User;
import ar.edu.unnoba.primero.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService){
        this.userService = userService;
    }


    @GetMapping("/new")
    public String userNew(Model model){
        model.addAttribute("user",new User());
        return "/users/new2";
    }
    @GetMapping("")
    public String index(Authentication authentication){
        User sessionUser = (User)authentication.getPrincipal();
        return "/users/index";
    }



    @PostMapping("/new")
    public String create(@ModelAttribute User user){

        userService.create(user);
        return "redirect:/";
    }
}


