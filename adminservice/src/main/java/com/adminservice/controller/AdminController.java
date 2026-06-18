package com.adminservice.controller;

import com.adminservice.client.User;
import com.adminservice.dto.AdminUserDto;
import com.adminservice.model.Admin;
import com.adminservice.service.AdminService;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    public final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
        Admin admin1=this.adminService.saveAdmin(admin);
        return new ResponseEntity<>(admin1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins(){
        return new ResponseEntity<>(this.adminService.getAllAdmins(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getSingleAdminById(@PathVariable Long id){
        return new ResponseEntity<>(this.adminService.getAdminById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id,@RequestBody Admin admin){
        return new ResponseEntity<>(this.adminService.updateAdmin(id,admin),HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Admin> patchAdmin(@PathVariable Long id,@RequestBody Admin admin){
        return new ResponseEntity<>(this.adminService.patchAdmin(id,admin),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id){
        this.adminService.deleteAdmin(id);
        return new ResponseEntity<>("Your Admin Deleted ",HttpStatus.OK);
    }
    @PostMapping("/{adminId}/onboard")
    public ResponseEntity<User> onBoardUser(@PathVariable Long adminId,@RequestBody User user){
        User saveUser=this.adminService.onBoardUserUser(adminId,user);
        return new ResponseEntity<>(saveUser,HttpStatus.CREATED);

    }
    @GetMapping("/{adminId}/users")
    public ResponseEntity<AdminUserDto> getUserUnderAdmin(@PathVariable Long adminId){
        return new ResponseEntity<>(this.adminService.getUsersUnderAdminid(adminId),HttpStatus.OK);
    }

}
