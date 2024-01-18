package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.User;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserIdAndUserPassword(String userId, String userPassword);

    @Modifying
    @Query("update User u set u.latestLoginAt = :latestAt where u.userId = :userId")
    int updateLatestLogin(@Param("userId") String userId, @Param("latestAt")LocalDateTime latestAt);
}
