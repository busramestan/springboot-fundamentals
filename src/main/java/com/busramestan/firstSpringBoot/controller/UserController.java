package com.busramestan.firstSpringBoot.controller;

import com.busramestan.firstSpringBoot.dto.request.UserRequest;
import com.busramestan.firstSpringBoot.dto.response.UserResponse;
import com.busramestan.firstSpringBoot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/save")
    public UserResponse saveUser(@RequestBody UserRequest userRequest){
        return userService.saveUser(userRequest);
    }

    @GetMapping(path = "/list")
    public Page<UserResponse> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){

        return userService.getAllUsers(page,size);
    }

    @GetMapping(path = "/find-user-by-id")
    public UserResponse findUserById(@RequestParam(value="id") Long id){
        return userService.getUserById(id);
    }

    @PutMapping(path = "/update/{id}")
    public UserResponse updateUser(@PathVariable(name = "id") Long id, @RequestBody UserRequest userRequest){
        return userService.updateUser(id, userRequest);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id ){
        userService.deleteUser(id);
    }




}
