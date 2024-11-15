package _1.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import _1.model.User;
import _1.service.UserService;



@Controller
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/adduser")
    public String openUserForm(@ModelAttribute("user") User user) {
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "adduser";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String openUpdateUserForm(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        }
        userService.updateUser(user);
        return "redirect:/";
    }


    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}