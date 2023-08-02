package com.example.inncretechcart.inncretech.services;

import com.example.inncretechcart.inncretech.dto.CartDTO;
import com.example.inncretechcart.inncretech.dto.ProductDTO;
import com.example.inncretechcart.inncretech.dto.UserDTO;

import java.util.List;


public interface CartService {

    public List<UserDTO> getUserId();

    public UserDTO getById(Long customerId);

    public UserDTO addId(UserDTO userid);


    UserDTO updateId(UserDTO userDTO);

    public void deleteId(Long parseLong);

    public CartDTO addCartId(CartDTO cartDTO);
    public List<CartDTO> getCartId();

    public CartDTO getCartByUserId(Long userId);

    public ProductDTO addProductId(ProductDTO productDTO);

    public ProductDTO getProductById(Long productId);


    public void addProductToCart(Long userId, Long productId, Long quantity);

}
