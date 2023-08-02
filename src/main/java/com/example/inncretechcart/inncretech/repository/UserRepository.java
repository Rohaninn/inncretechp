package com.example.inncretechcart.inncretech.repository;

import com.example.inncretechcart.inncretech.dto.UserDTO;
import com.example.inncretechcart.inncretech.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findById(Long userId);
}
