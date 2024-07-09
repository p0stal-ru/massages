package com.example.massages.services;

import com.example.massages.exceptions.UserNotFoundException;
import com.example.massages.models.User;
import com.example.massages.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public com.example.massages.dto.UserDto findUserById(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        return new com.example.massages.dto.UserDto(user);
    }

//    @Transactional
//    public User createUser(String userName, String password) {
//        User user = new User();
////        user.setCreateAt(new Date());
////        user.setCreateAt(LocalDateTime.now());
//        return this.userRepository.save(new User(null, userName, password));
//    }
//
//    @Transactional
//    public void updateUser(Integer userId, String userName, String password) {
//        this.userRepository.findById(userId)
//                .ifPresentOrElse(user -> {
//                    user.setUserName(userName);
//                    user.setPassword(password);
//                }, () -> {
//                    throw new NoSuchElementException();
//                });
//    }
//
//    @Transactional
//    public void deleteUser(Integer userId) {
//        this.userRepository.deleteById(userId);
//    }


//    public List<Publication> findPostAllByUserId(int id, Publication publication) {
//
//    }

//    @Transactional
//    public void save(User user) {
//        user.setCreateAt(new Date());
//        userRepository.save(user);
//    }



}
