package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Comment;
import esprit.tn.projetspringbootangular.Entities.EnumRole;
import esprit.tn.projetspringbootangular.Entities.Post;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Repository.CommentRepository;
import esprit.tn.projetspringbootangular.Repository.PostRepository;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentServiceImp  implements CommentService{

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository forumPostRepository;


    @Override
    public Comment addComment(Comment comment, Integer id_user, Post forumPost) {
        User user=userRepository.findById(id_user).get();
        comment.setUser(user);
        comment.setPost(forumPost);
        comment.setDateCreated(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Integer id) {
        return commentRepository.findById(id);
    }
    @Override
    public Comment updateComment(Integer id, Comment newComment,Integer id_user) throws AccessDeniedException {
        User currentUser=userRepository.findById(id_user).get();
        Optional<Comment> comment = commentRepository.findById(id);
        User commentUser = comment.get().getUser();
        if (currentUser.equals(commentUser) || currentUser.getRoles().equals(EnumRole.Admin)) {
            comment.get().setBody(newComment.getBody());
            return commentRepository.save(comment.get());
        } else {
            throw new AccessDeniedException("You do not have permission to update this comment.");
        }
    }

    @Override
    public void deleteComment(Integer id,Integer id_user) throws AccessDeniedException {
        User currentUser=userRepository.findById(id_user).get();
        Optional<Comment> comment = commentRepository.findById(id);

        User commentUser = comment.get().getUser();
        if (currentUser.equals(commentUser) || currentUser.getRoles().equals(EnumRole.Admin)) {
            commentRepository.deleteById(id);
        } else {
            throw new AccessDeniedException("You do not have permission to delete this comment.");
        }
    }

}
