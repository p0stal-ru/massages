package com.example.massages.services;


import com.example.massages.controllers.payload.PublicationDTO;
import com.example.massages.models.Publication;
import com.example.massages.models.User;
import com.example.massages.repositories.PublicationRepository;
import com.example.massages.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PublicationService {

    private final PublicationRepository publicationRepository;
    private final UserRepository userRepository;

    @Autowired
    public PublicationService(PublicationRepository publicationRepository, UserRepository userRepository) {
        this.publicationRepository = publicationRepository;
        this.userRepository = userRepository;
    }

    public List<Publication> findAllPosts() {
        return this.publicationRepository.findAll();
    }


    @Transactional
    public void createPost(User user, String title) {
        Integer id = user.getId();
        this.publicationRepository.save(new Publication(null, title, user));
    }

//    public Publication CreatePost(PublicationDTO publicationDTO, User user) {
////        User user = new User();
//        Publication publication = new Publication();
//        publication.setUser(user);
//        publication.setTitle(publicationDTO.title());
////        publication.setLikes(0);
//
//        return publicationRepository.save(publication);
//    }

//    public List<Publication> getAllPosts() {
//        Publication publication = new Publication();
//        publication.setCreateAt(new Date());
//        return publicationRepository.findAll();
//    }

//    public Publication getPostById(Long postId, User user) {
//        return publicationRepository.findByIdAndAndUser(postId, user).stream().findAny();
//    }




}
