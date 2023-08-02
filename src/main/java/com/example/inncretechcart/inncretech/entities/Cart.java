package com.example.inncretechcart.inncretech.entities;



import com.example.inncretechcart.inncretech.dto.CartItemDTO;
import com.example.inncretechcart.inncretech.dto.UserDTO;
import com.example.inncretechcart.inncretech.repository.UserRepository;
import com.example.inncretechcart.inncretech.dto.CartDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "IsActive")
    private Long IsActive;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    public Cart(Long cartId, Long userId, Long IsActive, List<CartItem> cartItems,String status) {
        this.cartId = cartId;
        this.userId = userId;
        this.IsActive = IsActive;
        this.cartItems = cartItems;
        this.status=status;
    }
    public Cart() {
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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItems.remove(cartItem);
        cartItem.setCart(null);
    }

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

        public Cart mapDTOToCart(CartDTO cartDTO) {
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
}

