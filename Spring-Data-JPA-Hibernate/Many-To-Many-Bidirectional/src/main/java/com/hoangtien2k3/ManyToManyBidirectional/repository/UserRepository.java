package com.hoangtien2k3.ManyToManyBidirectional.repository;


import com.hoangtien2k3.ManyToManyBidirectional.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}