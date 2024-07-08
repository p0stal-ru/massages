//package com.example.massages.dto;
//
//import com.example.massages.models.Publication;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDTO {
//
//    private int id;
//
//    @NotEmpty(message = "Имя не должно быть пустым")
//
//    private String userName;
//
//    @NotEmpty(message = "Имя не должно быть пустым")
//    @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters")
//    private String firstName;
//
//    @NotEmpty(message = "Имя не должно быть пустым")
//    @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters")
//    private String lastName;
//
//    @Min(value = 0, message = "Age should be greater than 0")
//    private int age;
//
//    @NotEmpty(message = "Имя не должно быть пустым")
//    @Email
//    private String email;
//
//    private List<Publication> publications = new ArrayList<>();
//
//    public UserDTO() {
//    }
//
//    public UserDTO(int id, String userName, String firstName, String lastName, int age, String email, List<Publication> publications) {
//        this.id = id;
//        this.userName = userName;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.email = email;
//        this.publications = publications;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public @NotEmpty(message = "Имя не должно быть пустым") String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(@NotEmpty(message = "Имя не должно быть пустым") String userName) {
//        this.userName = userName;
//    }
//
//    public @NotEmpty(message = "Имя не должно быть пустым") @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters") String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(@NotEmpty(message = "Имя не должно быть пустым") @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters") String firstName) {
//        this.firstName = firstName;
//    }
//
//    public @NotEmpty(message = "Имя не должно быть пустым") @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters") String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(@NotEmpty(message = "Имя не должно быть пустым") @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters") String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Min(value = 0, message = "Age should be greater than 0")
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(@Min(value = 0, message = "Age should be greater than 0") int age) {
//        this.age = age;
//    }
//
//    public @NotEmpty(message = "Имя не должно быть пустым") @Email String getEmail() {
//        return email;
//    }
//
//    public void setEmail(@NotEmpty(message = "Имя не должно быть пустым") @Email String email) {
//        this.email = email;
//    }
//
//    public List<Publication> getPublications() {
//        return publications;
//    }
//
//    public void setPublications(List<Publication> publications) {
//        this.publications = publications;
//    }
//}
