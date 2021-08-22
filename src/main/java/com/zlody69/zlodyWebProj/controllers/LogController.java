package com.zlody69.zlodyWebProj.controllers;

import com.zlody69.zlodyWebProj.model.Role;
import com.zlody69.zlodyWebProj.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "")
public class LogController {
    private final UserService userService;

    public LogController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }

    @GetMapping(value = "/hello")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @GetMapping(value = "/default")
    public String redirRole(HttpServletRequest request){
        if(request.isUserInRole("ROLE_ADMIN")){
            return "redirect:/admin/";
        }
        return "redirect:/user/";
    }

}
