package com.example.massages.services;


import com.example.massages.dto.PostDto;
import com.example.massages.dto.UserDto;
import com.example.massages.models.Post;
import com.example.massages.models.User;
import com.example.massages.repositories.PostRepository;
import com.example.massages.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    @Transactional
    public String createPost(PostDto dto) {

        User user = userRepository.findById(dto.getUserId()).orElse(null);

        Post post = Post.builder()
                .title(dto.getTitle())
                .likes(0)
                .user(user)
                .build();

        Post savedPost = postRepository.save(post);

        return String.valueOf(savedPost.getId());
    }


//    @Transactional
//    public void createPost(User user, String title) {
//        Integer id = user.getId();
//        this.publicationRepository.save(new Post(null, title, user));
//    }

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
