package com.example.inncretechcart.inncretech.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "is_active")
    private Long is_active;

    public User() {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.is_active = is_active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", is_active=" + is_active +
                '}';
    }

    // UserDTO
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
    }

    // Mapping from User entity to UserDTO
    public UserDTO mapUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setGender(user.getGender());
        userDTO.setIs_active(user.getIs_active());
        return userDTO;
    }
    public User mapDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setName(userDTO.getName());
        user.setGender(userDTO.getGender());
        user.setIs_active(userDTO.getIs_active());
        return user;
    }

}

