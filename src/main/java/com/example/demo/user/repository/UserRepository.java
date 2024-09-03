package com.example.demo.user.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
