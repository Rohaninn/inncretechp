package com.example.inncretechcart.inncretech.repository;

import com.example.inncretechcart.inncretech.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}

