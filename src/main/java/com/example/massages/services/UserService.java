package com.example.massages.services;

import com.example.massages.models.User;
import com.example.massages.repositories.PublicationRepository;
import com.example.massages.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;

    @Autowired
    public UserService(UserRepository userRepository, PublicationRepository publicationRepository) {
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(int id) {
//        Optional<User> byId = userRepository.findById(id);
//        return byId.orElseThrow(UserExistException);
        return this.userRepository.findById(id);
    }

    @Transactional
    public User createUser(String userName, String password) {
        User user = new User();
//        user.setCreateAt(new Date());
//        user.setCreateAt(LocalDateTime.now());
        return this.userRepository.save(new User(null, userName, password));
    }

    @Transactional
    public void updateUser(Integer userId, String userName, String password) {
        this.userRepository.findById(userId)
                .ifPresentOrElse(user -> {
                    user.setUserName(userName);
                    user.setPassword(password);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Transactional
    public void deleteUser(Integer userId) {
        this.userRepository.deleteById(userId);
    }


//    public List<Publication> findPostAllByUserId(int id, Publication publication) {
//
//    }

//    @Transactional
//    public void save(User user) {
//        user.setCreateAt(new Date());
//        userRepository.save(user);
//    }



}
