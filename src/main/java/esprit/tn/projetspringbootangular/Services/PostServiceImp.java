package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Post;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Exception.UnauthorizedException;
import esprit.tn.projetspringbootangular.Repository.PostRepository;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PostServiceImp implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImp(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }




    @Override
    public Integer addForumPost(Post forumPost, Integer id_user) {
        User user=userRepository.findById(id_user).orElse(null);
        forumPost.setUser(user);
        forumPost.setDateCreated(LocalDateTime.now());
        postRepository.save( forumPost);
        return forumPost.getPostId();



    }




    public List<Post> getAllForumPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getForumPostById(Integer id) {
        return postRepository.findById(id);
    }






    @Override
    public Post updateForumPost(Integer idPost, Post forumPost, Integer  id_user) {
        User user = userRepository.findById(id_user).get();
        Optional<Post> optionalForumPost = postRepository.findById(idPost);
        if (!optionalForumPost.isPresent()) {
            return null;
        }

        Post existingForumPost = optionalForumPost.get();
        if (!existingForumPost.getUser().equals(user)) {
            throw new UnauthorizedException("You are not authorized to update this forum post");
        }

        existingForumPost.setTitle(forumPost.getTitle());
        existingForumPost.setBody(forumPost.getBody());
        return postRepository.save(existingForumPost);
    }

    @Override
    public boolean deleteForumPost(Integer id, Integer   id_user) {
        User user = userRepository.findById(id_user).get();
        Optional<Post> optionalForumPost = postRepository.findById(id);
        if (!optionalForumPost.isPresent()) {
            return false;
        }

        Post existingForumPost = optionalForumPost.get();
        if (!existingForumPost.getUser().equals(user)) {
            throw new UnauthorizedException("You are not authorized to delete this forum post");
        }

        postRepository.delete(existingForumPost);
        return true;
    }
}
