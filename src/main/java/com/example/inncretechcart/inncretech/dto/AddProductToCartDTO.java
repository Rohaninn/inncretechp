package com.example.inncretechcart.inncretech.dto;

public class AddProductToCartDTO {
    private Long userId;
    private Long productId;
    private Long quantity;

    // Default constructor
    public AddProductToCartDTO() {
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
