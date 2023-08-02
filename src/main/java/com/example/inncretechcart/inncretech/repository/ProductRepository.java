package com.example.inncretechcart.inncretech.repository;

import com.example.inncretechcart.inncretech.dto.ProductDTO;

import com.example.inncretechcart.inncretech.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByProductId(Long productId);
}

