package com.zlody69.zlodyWebProj.controllers;

import com.zlody69.zlodyWebProj.model.User;
import com.zlody69.zlodyWebProj.services.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping( value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public String allUser(Model model){
        model.addAttribute("users",userService.allUser());
        return "all_users";
    }

    @GetMapping(value = "/{id}")
    public String findUser(Model model, @PathVariable("id")Long id){
        model.addAttribute("curent_user", userService.findUser(id));
        return "user";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id")Long id){
        model.addAttribute("update_user", userService.findUser(id));
        return "update_user";
    }

    @GetMapping(value = "/create")
    public String addUser(@ModelAttribute("user") User user){
        return "create_user";
    }

    @PutMapping(value ="/{id}")
    public String updateUser(@ModelAttribute("user")User user, @PathVariable("id")Long id){
        userService.updateUser(user,id);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user")User user){
        System.out.println("post proshel1");
        userService.addUser(user);
        System.out.println("post proshel2");
        return "redirect:/users";
    }
}
