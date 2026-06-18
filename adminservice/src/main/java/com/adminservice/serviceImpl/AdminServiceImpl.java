package com.adminservice.serviceImpl;

import com.adminservice.client.User;
import com.adminservice.dto.AdminUserDto;
import com.adminservice.feingClient.UserClient;
import com.adminservice.model.Admin;
import com.adminservice.repository.AdminRepository;
import com.adminservice.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    private final UserClient userClient;

    public AdminServiceImpl(AdminRepository adminRepository, UserClient userClient) {
        this.adminRepository = adminRepository;
        this.userClient = userClient;
    }


    @Override
    public Admin saveAdmin(Admin admin) {
        return this.adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return this.adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long id) {
        Admin admin1=adminRepository.findById(id).orElse(null);
        return admin1;
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        Admin admin1=adminRepository.findById(id).orElse(null);
        if (admin1 != null){
            admin1.setName(admin.getName());
            admin1.setEmail(admin.getEmail());
            admin1.setRole(admin.getRole());
            return adminRepository.save(admin1);
        }
        return null;
    }

    @Override
    public Admin patchAdmin(Long id, Admin admin) {
        Admin admin1=adminRepository.findById(id).orElse(null);
        if (admin1 != null){

            if(admin.getName()!=null){
                admin1.setName(admin.getName());
            }
            if (admin.getEmail() != null){
                admin1.setEmail(admin.getEmail());
            }
            if (admin.getRole()!=null){
                admin1.setRole(admin.getRole());
            }
            return this.adminRepository.save(admin1);
        }

        return null;
    }

    @Override
    public void deleteAdmin(Long id) {
        this.adminRepository.deleteById(id);

    }

    @Override
    public User onBoardUserUser(Long adminId, User user) {
        user.setAdminId(adminId);
        return this.userClient.createUser(user);
    }


    @Override
    public AdminUserDto getUsersUnderAdminid(Long adminId) {

        Admin admin = adminRepository.findById(adminId)
                .orElse(null);

        List<User> users =
                userClient.getUsersByAdminId(adminId);

        AdminUserDto dto = new AdminUserDto();

        dto.setAdminId(admin.getAdminId());
        dto.setName(admin.getName());
        dto.setEmail(admin.getEmail());
        dto.setRole(admin.getRole());
        dto.setUsers(users);

        return dto;
    }
}
