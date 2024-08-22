package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "UsersPage";
    }

    @GetMapping("/id")
    public String GeyUserById(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "UserPage";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "createUser";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") /*@Valid*/ User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createUser";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam(value = "id", required = false) long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "updateUser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") /*@Valid*/ User user, BindingResult bindingResult,
                             @RequestParam(value = "id") long id) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        }
        System.out.println("userUpdate");
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/id")
    public String deleteUser(@RequestParam(value = "id") long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}

