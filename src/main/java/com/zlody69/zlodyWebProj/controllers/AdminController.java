package com.zlody69.zlodyWebProj.controllers;

import com.zlody69.zlodyWebProj.model.Role;
import com.zlody69.zlodyWebProj.model.User;
import com.zlody69.zlodyWebProj.services.RoleService;
import com.zlody69.zlodyWebProj.services.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping( value = "/admin")
public class AdminController {

    private final UserService userService;

    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "")
    public String allUser(Model model){
        model.addAttribute("users",userService.allUser());
        return "all_users";
    }

    @GetMapping(value = "/{id}")
    public String findUser(Model model, @PathVariable("id")Long id){
        model.addAttribute("curent_user", userService.findUser(id));
        return "user_admin";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id")Long id){
        model.addAttribute("update_user", userService.findUser(id));
        model.addAttribute("allRole", roleService.allRoles());
        return "update_user_admin";
    }

    @GetMapping(value = "/create")
    public String addUser(@ModelAttribute("user") User user, Model model){
        model.addAttribute("allRole", roleService.allRoles());
        return "create_user";
    }

    @PutMapping(value ="/{id}")
    public String updateUser(@ModelAttribute("user")User user,
                             @PathVariable("id")Long id,
                             @RequestParam("role") String[] roles){
        User upUser = user;
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles){
            roleSet.add(roleService.findRoleByName(role));
        }
        upUser.setRoles(roleSet);
        userService.updateUser(upUser, id);
        return "redirect:/admin";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user")User user,
                             @RequestParam("role") String[] roles){
        User upUser = user;
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles){
            roleSet.add(roleService.findRoleByName(role));
        }
        upUser.setRoles(roleSet);
        userService.addUser(upUser);
        return "redirect:/admin";
    }


}
