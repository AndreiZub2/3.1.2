package ru.java.JavaSpringBoot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.java.JavaSpringBoot.model.User;
import ru.java.JavaSpringBoot.service.UserService;


import java.util.List;

@Controller

public class UserListController {
    private final UserService userService;

    public UserListController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String allUsers(Model model){
        List<User> userList = userService.getUserList();
        model.addAttribute("allUsr", userList);
        return "all-user";
    }

    @RequestMapping("/addNewUsers")
    public String addNewUsers(Model model){
        User user = new User();
        model.addAttribute("user",user);

        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);

        return "redirect:/";
    }

    @RequestMapping( "/updateInfo")
    public String updateUser(@RequestParam("usrId") Long id, Model model){
        User user  = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("usrId")Long id){
    userService.deleteUser(id);
        return "redirect:/";
    }

}
