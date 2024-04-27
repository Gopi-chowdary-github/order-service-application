package com.microservice.orderservice.domain;

import com.microservice.orderservice.Entity.Role;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    String name;

    String password;
    String email;
    List<Role> role;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }

    public List<Role> getRole() {
        return role;
    }
}
