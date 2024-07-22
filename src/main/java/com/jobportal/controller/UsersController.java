package com.jobportal.controller;

import com.jobportal.entity.Users;
import com.jobportal.entity.UsersType;
import com.jobportal.service.UsersService;
import com.jobportal.service.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {

    private final UsersService usersService;
    private final UsersTypeService usersTypeService;

    @Autowired
    public UsersController(UsersService usersService, UsersTypeService usersTypeService) {
        this.usersService = usersService;
        this.usersTypeService = usersTypeService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users user, Model model) {
        Optional<Users> optionalUsers = usersService.getUserByEmail(user.getEmail());
        if (optionalUsers.isPresent()) {
            model.addAttribute("error", "Email này đã được đăng ký, hãy thử đăng ký bằng email khác.");
            List<UsersType> usersTypes = usersTypeService.getAll();
            model.addAttribute("getAllTypes", usersTypes);
            model.addAttribute("user", new Users());
            return "register";
        }
        //System.out.println("User:: " + user);
        usersService.addNew(user);
        return "dashboard";
    }
}
