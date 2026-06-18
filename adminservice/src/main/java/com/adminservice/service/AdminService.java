package com.adminservice.service;

import com.adminservice.client.User;
import com.adminservice.model.Admin;
import com.adminservice.dto.AdminUserDto;

import java.util.List;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    List<Admin> getAllAdmins();

    Admin getAdminById(Long id);

    Admin updateAdmin(Long id, Admin admin);

    Admin patchAdmin(Long id, Admin admin);

    void deleteAdmin(Long id);

    User onBoardUserUser(Long id,User user);



    AdminUserDto getUsersUnderAdminid(Long adminId);
}
