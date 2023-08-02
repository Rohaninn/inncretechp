package com.example.inncretechcart.inncretech.services;


import com.example.inncretechcart.inncretech.entities.Cart;
import com.example.inncretechcart.inncretech.entities.CartItem;
import com.example.inncretechcart.inncretech.entities.Product;
import com.example.inncretechcart.inncretech.entities.User;
import com.example.inncretechcart.inncretech.repository.CartRepository;
import com.example.inncretechcart.inncretech.repository.ProductRepository;
import com.example.inncretechcart.inncretech.repository.UserRepository;
import com.example.inncretechcart.inncretech.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;




//    List<UserDTO> userData;
//    List<CartDTO> cartData;
//
//    List<AddProductToCartDTO> addProductData;
//
//    List<ProductDTO> productData;

    public CartServiceImpl() {
//        userData = new ArrayList<>();
//        userData.add(new UserDTO(1L, "Rohan Maheshwary", "M", 1L));
//        userData.add(new UserDTO(2L, "Naveen Jakad", "M", 1L));
//
//        cartData = new ArrayList<>();
//        cartData.add(new CartDTO(1L,1L,1L));
//        cartData.add(new CartDTO(2L,2L,1L));
//
//        addProductData=new ArrayList<>();
//        addProductData.add(new AddProductToCartDTO(1L,1L,1L));
//
//        productData=new ArrayList<>();
//        productData.add(new ProductDTO(1L,"Burger","Maharaja Burger",new BigDecimal("130.00")));


    }

    @Override
    public List<UserDTO> getUserId() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = mapUserToDTO(user);
            // Perform additional transformation or manipulation on the DTO if needed
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

    public UserDTO getById(Long customerId) {
        Optional<User> optionalUser = userRepository.findById(customerId);
        return optionalUser.map(this::mapUserToDTO).orElse(null);
    }

    @Override
    public UserDTO addId(UserDTO userDTO) {
        User user = mapDTOToUser(userDTO);
        userRepository.save(user);
        return mapUserToDTO(user);
    }

    @Override
    public UserDTO updateId(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(userDTO.getUserId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Update the entity properties using the values from the DTO
            user.setName(userDTO.getName());
            user.setGender(userDTO.getGender());
            // Set other properties as needed

            // Save the updated entity in the repository
            userRepository.save(user);

            // Map the updated entity back to a UserDTO
            return mapUserToDTO(user);
        } else {
            // Handle the case when the user is not found
            return null;
        }
    }

    @Override
    public void deleteId(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public CartDTO addCartId(CartDTO cartDTO) {
        Cart cart= mapDTOToCart(cartDTO);
        cartRepository.save(cart);
        return mapCartToDTO(cart);
    }
    @Override
    public List<CartDTO> getCartId() {
        List<Cart> carts = cartRepository.findAll();
        List<CartDTO> cartDTOs = new ArrayList<>();

        for (Cart cart : carts) {
            CartDTO cartDTO = mapCartToDTO(cart);
            // Perform additional transformation or manipulation on the DTO if needed
            cartDTOs.add(cartDTO);
        }

        return cartDTOs;
    }


    public CartDTO getCartByUserId(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        return mapCartToDTO(cart);
    }
    @Override
    public ProductDTO addProductId(ProductDTO productDTO) {
        Product product= mapDTOToProduct(productDTO);
        productRepository.save(product);
        return mapProductToDTO(product);
    }

    public ProductDTO getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findByProductId(productId);
        return optionalProduct.map(this::mapProductToDTO).orElse(null);
    }

    public void addProductToCart(Long userId, Long productId, Long quantity) {
        // Step 1: Get user cart by user ID or create a new cart if it doesn't exist
        CartDTO cart = getCartByUserId(userId);
        if (cart == null) {
            cart = new CartDTO();
            cart.setUserId(userId);
            // Set other cart properties if needed
        }

        // Step 2: Check if the product exists in the cart
        boolean productExists = false;
        for (CartItemDTO item : cart.getCartItems()) {
            if (item.getProduct().getProductId().equals(productId)) {
                // Product already exists, update the quantity
                item.setQuantity(item.getQuantity() + quantity);
                productExists = true;
                break;
            }
        }

        // Product doesn't exist, add it to the cart
        if (!productExists) {
            ProductDTO product = getProductById(productId);
            if (product != null) {
                CartItemDTO newItem = new CartItemDTO();
                newItem.setProduct(product);
                newItem.setQuantity(quantity);
                cart.getCartItems().add(newItem);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with ID: " + productId);
                // Handle the case when the product is not found
            }
        }

        // Save or update the cart in the repository
        cartRepository.save(mapDTOToCart(cart));

        cart = getCartByUserId(userId);
    }
    public UserDTO mapUserToDTO(User user) {
        UserDTO userDTO = this.modelMapper.map(user,UserDTO.class);
//        userDTO.setId(user.getUserId());
//        userDTO.setName(user.getName());
//        userDTO.setGender(user.getGender());
//        userDTO.setIs_active(user.getIs_active();
        return userDTO;
    }
    public User mapDTOToUser(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO,User.class);
//        user.setUserId(userDTO.getId());
//        user.setName(userDTO.getName());
//        user.setGender(userDTO.getGender());
//        user.setIs_active(userDTO.getIs_active());
        return user;
    }
    // Mapping from Cart entity to CartDTO
    public CartDTO mapCartToDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        cartDTO.setUserId(cart.getUserId());
        cartDTO.setIsActive(cart.getIsActive());
        cartDTO.setStatus(cart.getStatus());
        List<CartItemDTO> cartItems = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            CartItemDTO cartItemDTO = new CartItemDTO();
            ProductDTO productDTO=new ProductDTO();
            productDTO.setProductId(cartItem.getProduct().getProductId());
            cartItemDTO.setProduct(productDTO);
            cartItemDTO.setQuantity(cartItemDTO.getQuantity());

            cartItems.add(cartItemDTO);
        }
        cartDTO.setCartItems(cartItems);

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
            cartItem.setCart(cart);
            // Map the properties from CartItemDTO to CartItem
            Optional<Product> byProductId = productRepository.findByProductId(cartItemDTO.getProduct().getProductId());
            cartItem.setProduct(byProductId.get());
            cartItem.setQuantity(cartItemDTO.getQuantity());
            // Set other properties as needed
            cartItems.add(cartItem);
        }
        cart.setCartItems(cartItems);
        // Set other properties as needed

        return cart;
    }


    public ProductDTO mapProductToDTO(Product product) {
        ProductDTO productDTO = this.modelMapper.map(product,ProductDTO.class);
//        productDTO.setProductId(product.getProductId());
//        productDTO.setName(product.getName());
//        productDTO.setDescription(product.getDescription());
//        productDTO.setPrice(product.getPrice());

        return productDTO;
    }

    // Mapping from ProductDTO to Product entity
    public Product mapDTOToProduct(ProductDTO productDTO) {
        Product product = this.modelMapper.map(productDTO,Product.class);
//        product.setProductId(productDTO.getProductId());
//        product.setName(productDTO.getName());
//        product.setDescription(productDTO.getDescription());
//        product.setPrice(productDTO.getPrice());

        return product;
    }
    public CartItemDTO mapCartItemToDTO(CartItem cartItem) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setItemId(cartItem.getItemId());
        cartItemDTO.setProduct(mapProductToDTO(cartItem.getProduct()));
        cartItemDTO.setQuantity(cartItem.getQuantity());
        cartItemDTO.setCart(mapCartToDTO(cartItem.getCart()));
        return cartItemDTO;
    }

    public CartItem mapDTOToCartItem(CartItemDTO cartItemDTO) {
        CartItem cartItem = new CartItem();
        cartItem.setItemId(cartItemDTO.getItemId());
        cartItem.setProduct(mapDTOToProduct(cartItemDTO.getProduct()));
        cartItem.setQuantity(cartItemDTO.getQuantity());
        cartItemDTO.setCart(mapCartToDTO(cartItem.getCart()));
        return cartItem;
    }


}



