package com.example.redalback.Repository;

import com.example.redalback.login.Users;
import com.example.redalback.usersdto.UsersDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByemail(String email);
}
