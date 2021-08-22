package com.zlody69.zlodyWebProj.controllers;

import com.zlody69.zlodyWebProj.model.User;
import com.zlody69.zlodyWebProj.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String findUser(Model model, Principal principal){
        System.out.println("vse ok");
        User user = userService.findUserByUsername(principal.getName());
        model.addAttribute("curent_user", user);
        return "user";
    }

    @GetMapping(value = "/edit")
    public String editUser(Model model, Principal principal){
        User user = userService.findUserByUsername(principal.getName());
        model.addAttribute("update_user", user);
        return "update_user";
    }

    @PutMapping(value ="/update")
    public String updateUser(@ModelAttribute("user")User user, Principal principal){
        User upUser = userService.findUserByUsername(principal.getName());
        userService.updateUser(user, upUser.getId());
        return "redirect:/user/";
    }
}
