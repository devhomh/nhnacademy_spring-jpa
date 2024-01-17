package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.User;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserIdAndUserPassword(String userId, String userPassword);
    int updateLatestAtByUserId(String userId, LocalDateTime latestAt);
}
