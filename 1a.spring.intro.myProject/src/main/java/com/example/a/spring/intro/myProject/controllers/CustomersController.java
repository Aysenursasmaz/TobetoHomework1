package com.example.a.spring.intro.myProject.controllers;

import com.example.a.spring.intro.myProject.services.abstracts.UserService;
import com.example.a.spring.intro.myProject.services.dtos.user.requests.AddUserRequest;
import com.example.a.spring.intro.myProject.services.dtos.user.requests.UpdateUserRequest;
import com.example.a.spring.intro.myProject.services.dtos.user.responses.GetListUserResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")

public class CustomersController {
 private UserService userService;

    public CustomersController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public void add(@RequestBody @Valid AddUserRequest request){
        userService.add(request);
    }
    @PutMapping("{id}")
    public void update(@RequestBody @Valid UpdateUserRequest request){
        userService.update(request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
    @GetMapping("dto")
        public List<GetListUserResponse> orderById(){
        return userService.orderById();
    }
    @GetMapping("dto/lastName")
    public List<GetListUserResponse> getByLastName(){
        return userService.getByLastName();
    }
}
