package com.example.restfulwebservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 데이터베이스와 관련된 bean
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
