package com.example.inncretechcart.inncretech.controller;

import com.example.inncretechcart.inncretech.dto.AddProductToCartDTO;
import com.example.inncretechcart.inncretech.dto.CartDTO;
import com.example.inncretechcart.inncretech.dto.ProductDTO;
import com.example.inncretechcart.inncretech.dto.UserDTO;
import com.example.inncretechcart.inncretech.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartSerivice;

    @GetMapping("/home")
    public String home() {
        return "this is home page";
    }

    // get the cart ids
    @GetMapping("/ids")
    public List<UserDTO> getUserId() {
        return this.cartSerivice.getUserId();

    }

    @GetMapping("/ids/{customerId}")
    public UserDTO getById(@PathVariable String customerId) {
        return this.cartSerivice.getById(Long.parseLong(customerId));

    }

    @PostMapping("/ids")
    public UserDTO addId(@RequestBody UserDTO userid) {
        return this.cartSerivice.addId(userid);

    }

    @PutMapping("/ids")
    public UserDTO updateId(@RequestBody UserDTO userid) {
        return this.cartSerivice.updateId(userid);
    }

    @DeleteMapping("/ids/{customerId}")
    public ResponseEntity<HttpStatus> deleteId(@PathVariable String customerId) {
        try {
            this.cartSerivice.deleteId(Long.parseLong(customerId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/cid")
    public CartDTO addCartId(@RequestBody CartDTO cartDTO) {
        return this.cartSerivice.addCartId(cartDTO);

    }
    @GetMapping("/cid")
    public List<CartDTO> getCartId() {
        return this.cartSerivice.getCartId();
    }

    @GetMapping("/cid/{userId}")
    public CartDTO getCartByUserId(@PathVariable String userId) {
        return this.cartSerivice.getCartByUserId(Long.parseLong(userId));

    }
    @PostMapping("/pid")
    public ProductDTO addProductId(@RequestBody ProductDTO productDTO) {
        return this.cartSerivice.addProductId(productDTO);

    }
    @GetMapping("/pid/{productId}")
    public ProductDTO getProductById(@PathVariable String productId){
        return this.cartSerivice.getProductById(Long.parseLong(productId));
    }
    @PostMapping("/addcart")
    public ResponseEntity<String> addProductToCart(@RequestBody AddProductToCartDTO addProductToCartDTO) {
        // Extract data from the DTO and call the service method
        Long userId = addProductToCartDTO.getUserId();
        Long productId = addProductToCartDTO.getProductId();
        Long quantity = addProductToCartDTO.getQuantity();

        cartSerivice.addProductToCart(userId, productId, quantity);

        return ResponseEntity.ok("Product added to cart successfully");
    }

}

