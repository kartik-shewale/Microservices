package com.kartik.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kartik.app.Entity.User;

public interface UserRepo extends JpaRepository<User, String> {
    // Additional query methods can be defined here
}
