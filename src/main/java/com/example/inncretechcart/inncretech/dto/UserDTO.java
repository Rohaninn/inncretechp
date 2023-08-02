package com.example.inncretechcart.inncretech.dto;

import com.example.inncretechcart.inncretech.entities.User;

public class UserDTO {


    private Long userId;
    private String name;
    private String gender;
    private Long is_active;

    public UserDTO() {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.is_active = is_active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getIs_active() {
        return is_active;
    }

    public void setIs_active(Long is_active) {
        this.is_active = is_active;
    }
    // DTO fields, getters, and setters


    // Mapping from User entity to UserDTO
    public UserDTO mapUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setGender(user.getGender());
        userDTO.setIs_active(user.getIs_active());
        return userDTO;
    }
    public User mapDTOToUser(User.UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setName(userDTO.getName());
        user.setGender(userDTO.getGender());
        user.setIs_active(userDTO.getIs_active());
        return user;
    }

}
