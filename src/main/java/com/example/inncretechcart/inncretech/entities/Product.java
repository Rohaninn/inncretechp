package com.example.inncretechcart.inncretech.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "name")
    private String name;


    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;


    public Product(Long productId, String name, String description, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product() {

    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public class ProductDTO {
        private Long productId;
        private String name;
        private String description;
        private BigDecimal price;


        public ProductDTO(Long productId, String name, String description, BigDecimal price) {
            this.productId = productId;
            this.name = name;
            this.description = description;
            this.price = price;

        }

        public ProductDTO() {

        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }


        // DTO fields, getters, and setters

        // Mapping from Product entity to ProductDTO
        public ProductDTO mapProductToDTO(Product product) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(product.getProductId());
            productDTO.setName(product.getName());
            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());
            return productDTO;
        }

        // Mapping from ProductDTO to Product entity
        public Product mapDTOToProduct(ProductDTO productDTO) {
            Product product = new Product();
            product.setProductId(productDTO.getProductId());
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());

            return product;
        }
    }
}



