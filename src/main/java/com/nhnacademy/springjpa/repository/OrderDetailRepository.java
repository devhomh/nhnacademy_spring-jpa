package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetail.Pk> {
    //TODO: 아이디별로 orderdetail 조회
}
