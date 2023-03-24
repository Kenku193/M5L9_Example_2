package com.example.m5l9_example_2.controller;

import com.example.m5l9_example_2.entity.User;
import com.example.m5l9_example_2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ModelAndView showAllusers(ModelAndView view){
        view.addObject("users", userService.findAll());
        view.setViewName("userpage");
        return view;
    }

    @GetMapping("/{id}")
    public ModelAndView showOneUserAndAllUsers(ModelAndView view, @PathVariable Long id){

        Optional<User> optionalUserById = userService.findById(id);
        if (optionalUserById.isPresent()){
            view.addObject("user", optionalUserById.get());
            view.addObject("users", userService.findAll());
        }
        view.setViewName("userpage");
        return view;
    }


    @PostMapping
    public String createOrLoginUser(ModelAndView view,
                                    User user,
                                    @RequestParam(required = false) String createUser)
    {
        view.setViewName("userpage");
        if (Objects.nonNull(createUser)){
            userService.save(user);
            return "redirect:/users/%d/".formatted(user.getId());
        }
        else {
            System.out.println("User " + user.toString() + "logged on");
            return "redirect:/users";
        }
    }

    @PostMapping("/{id}")
    public String updateOrDeleteUser(ModelAndView view,
                                     User user,
                                     @RequestParam(required = false) String deleteUser)
    {
        view.setViewName("userpage");
        if (Objects.nonNull(deleteUser)){
            userService.delete(user);
            return "redirect:/";
        }
        else {
            userService.update(user);
            return "redirect:/users/%d/".formatted(user.getId());
        }
    }

//    @PostMapping (C)
//    @GetMapping (R)
//    @PutMapping (U)
//    @DeleteMapping (D)

}
