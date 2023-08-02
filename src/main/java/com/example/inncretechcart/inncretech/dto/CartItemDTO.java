package com.example.inncretechcart.inncretech.dto;

import com.example.inncretechcart.inncretech.entities.Cart;
import com.example.inncretechcart.inncretech.entities.CartItem;
import com.example.inncretechcart.inncretech.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CartItemDTO {
    private Long itemId;
    private ProductDTO product;
    private Long quantity;
    private CartDTO cart;

    public CartItemDTO(Long itemId, ProductDTO product, Long quantity, CartDTO cart) {
        this.itemId = itemId;
        this.product = product;
        this.quantity = quantity;
        this.cart = cart;
    }
    public CartItemDTO() {
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public CartDTO getCart() {
        return cart;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }


    public CartItemDTO mapCartItemToDTO(CartItem cartItem) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setItemId(cartItem.getItemId());
        cartItemDTO.setProduct(mapProductToDTO(cartItem.getProduct()));
        cartItemDTO.setQuantity(cartItem.getQuantity());
        return cartItemDTO;
    }

    public CartItem mapDTOToCartItem(CartItem.CartItemDTO cartItemDTO) {
        CartItem cartItem = new CartItem();
        cartItem.setItemId(cartItemDTO.getItemId());
        cartItem.setProduct(mapDTOToProduct(cartItemDTO.getProduct()));
        cartItem.setQuantity(cartItemDTO.getQuantity());
        return cartItem;
    }

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
    public CartDTO mapCartToDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        cartDTO.setUserId(cart.getUserId());
        cartDTO.setIsActive(cart.getIsActive());
        cartDTO.setCartItems(cartDTO.getCartItems());
        cartDTO.setStatus(cartDTO.getStatus());

        return cartDTO;
    }

    // Mapping from CartDTO to Cart entity
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
            // cartItem.setProductId(cartItemDTO.getProductId());
            // cartItem.setQuantity(cartItemDTO.getQuantity());
            // Set other properties as needed
            cartItems.add(cartItem);
        }
        cart.setCartItems(cartItems);

        // Set other properties as needed

        return cart;
    }

}

