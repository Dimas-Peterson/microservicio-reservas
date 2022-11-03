package com.user.service.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.userEntity.User;

@Repository
public interface iUserRepository extends JpaRepository<User, Integer>{

}
