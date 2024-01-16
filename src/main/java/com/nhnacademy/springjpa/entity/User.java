package com.nhnacademy.springjpa.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "UserID")
    private String userId;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "UserPassword")
    private String userPassword;

    @Column(name = "UserBirth")
    private String userBirth;

    @Column(name = "UserAuth")
    private String userAuth;

    @Column(name = "UserPoint")
    private Integer userPoint;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "LatestLoginAt")
    private LocalDateTime latestLoginAt;

}
