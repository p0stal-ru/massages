//package com.example.massages.dto;
//
//import com.example.massages.models.User;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//public class PublicationDTO {
//
//    private Long id;
//
//    private String title;
//
//    private Integer likes;
//
//    private User user;
//
////    @OneToMany(cascade = CascadeType.REFRESH ,mappedBy = "publication")
////    private List<?> connects = new ArrayList<>();
//
//    private Date createAt;
//
//    public PublicationDTO() {
//    }
//
//    public PublicationDTO(Long id, String title, Integer likes, User user, Date createAt) {
//        this.id = id;
//        this.title = title;
//        this.likes = likes;
//        this.user = user;
//        this.createAt = createAt;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Integer getLikes() {
//        return likes;
//    }
//
//    public void setLikes(Integer likes) {
//        this.likes = likes;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Date getCreateAt() {
//        return createAt;
//    }
//
//    public void setCreateAt(Date createAt) {
//        this.createAt = createAt;
//    }
//}
//
