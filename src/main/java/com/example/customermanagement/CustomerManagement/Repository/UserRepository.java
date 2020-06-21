package com.example.customermanagement.CustomerManagement.Repository;

import com.example.customermanagement.CustomerManagement.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
