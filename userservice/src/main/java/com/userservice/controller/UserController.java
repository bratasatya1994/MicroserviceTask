package com.userservice.controller;

import com.userservice.model.User;
import com.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser=this.userService.saveuser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
       List<User>  getAllUsers=this.userService.getAllUsers();
       return new ResponseEntity<>(getAllUsers,HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.getUserById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        return new ResponseEntity<>(this.userService.updateUser(id,user),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> patchUser(@PathVariable Long id,@RequestBody User user){
        User updatedUser = this.userService.patchUser(id, user);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

       this.userService.deleteUser(id);

        return new ResponseEntity<>("Selected User Successfully Deleted", HttpStatus.OK);
    }
    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<User>>
    getUsersByAdminId(
            @PathVariable Long adminId){

        return ResponseEntity.ok(
               this.userService.getUsersByAdminId(adminId));
    }
}
