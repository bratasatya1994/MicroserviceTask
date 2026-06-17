package com.adminservice.feingClient;

import com.adminservice.client.User;
import com.adminservice.model.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "user-service",
        url = "http://localhost:8081"
)
public interface UserClient {

    @PostMapping("/users")
    User createUser(@RequestBody User user);

    @GetMapping("/users/admin/{adminId}")
    List<User> getUsersByAdminId(
            @PathVariable("adminId") Long adminId);

}
