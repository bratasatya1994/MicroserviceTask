package com.userservice.serviceImpl;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public User saveuser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        User user1= this.userRepository.findById(id).orElse(null);
        if (user1 != null){
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
            user1.setPhone(user.getPhone());
            user1.setRole(user.getRole());
            user1.setAdminId(user.getAdminId());

            return this.userRepository.save(user1);
        }

        return null;
    }

    @Override
    public User patchUser(Long id, User user) {

        User user1=this.userRepository.findById(id).orElse(null);
        if (user1 != null){
            if(user.getName()!=null){
                user1.setName(user.getName());
            }
            if (user.getEmail() != null){
                user1.setEmail(user.getEmail());
            }
            if (user.getPhone() != null){
                user1.setPhone(user.getPhone());
            }
            if (user.getRole() != null){
                user1.setRole(user.getRole());
            }
            if (user.getAdminId() != null){
                user1.setAdminId(user.getAdminId());
            }
            return this.userRepository.save(user1);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);

    }
    @Override
    public List<User> getUsersByAdminId(Long adminId) {

        return userRepository.findByAdminId(adminId);
    }
}
