package com.example.inncretechcart.inncretech.dto;

import com.example.inncretechcart.inncretech.entities.Cart;
import com.example.inncretechcart.inncretech.entities.CartItem;
import com.example.inncretechcart.inncretech.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
    private Long cartId;
    private Long userId;
    private Long IsActive;

    private List<CartItemDTO> cartItems = new ArrayList<>();

    private String status;


    public CartDTO() {
        this.cartId = cartId;
        this.userId = userId;
        this.IsActive = IsActive;
        this.cartItems = cartItems;
        this.status=status;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIsActive() {
        return IsActive;
    }

    public void setIsActive(Long IsActive) {
        this.IsActive = IsActive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // DTO fields, getters, and setters


    private UserRepository userRepository;

    // Mapping from Cart entity to CartDTO
    public CartDTO mapCartToDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        cartDTO.setUserId(cart.getUserId());
        cartDTO.setIsActive(cart.getIsActive());
        cartDTO.setStatus(cart.getStatus());

        List<CartItemDTO> cartItemDTOs = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            CartItemDTO cartItemDTO = new CartItemDTO();
            // Map the properties from CartItem to CartItemDTO
            // cartItemDTO.setItemId(cartItem.getItemId());
            // cartItemDTO.setProduct(mapProductToDTO(cartItem.getProduct()));
            // cartItemDTO.setQuantity(cartItem.getQuantity());
            // Set other properties as needed
            cartItemDTOs.add(cartItemDTO);
        }
        cartDTO.setCartItems(cartItemDTOs);

        return cartDTO;
    }

    public Cart mapDTOToCart(Cart.CartDTO cartDTO) {
        Cart cart = new Cart();
        cart.setCartId(cartDTO.getCartId());
        cart.setUserId(cartDTO.getUserId());
        cart.setIsActive(cartDTO.getIsActive());
        cart.setStatus(cartDTO.getStatus());

        List<CartItem> cartItems = new ArrayList<>();
        for (CartItemDTO cartItemDTO : cartDTO.getCartItems()) {
            CartItem cartItem = new CartItem();
            // Map the properties from CartItemDTO to CartItem
            // cartItem.setItemId(cartItemDTO.getItemId());
            // cartItem.setProduct(mapDTOToProduct(cartItemDTO.getProduct()));
            // cartItem.setQuantity(cartItemDTO.getQuantity());
            // Set other properties as needed
            cartItems.add(cartItem);
        }
        cart.setCartItems(cartItems);

        return cart;
    }

}


