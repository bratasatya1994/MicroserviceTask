package com.adminservice.dto;

import com.adminservice.client.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserDto {

    private Long adminId;
    private String name;
    private String email;
    private String role;
    private List<User> users;
}
