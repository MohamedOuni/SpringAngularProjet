package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Comment;
import esprit.tn.projetspringbootangular.Entities.Post;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

public interface CommentService {
    public Comment addComment(Comment comment, Integer id_user, Post forumPost);
    public List<Comment> getAllComments();
    public Optional<Comment> getCommentById(Integer id);
    public Comment updateComment(Integer id, Comment newComment, Integer id_user) throws AccessDeniedException;
    public void deleteComment(Integer id,Integer id_user) throws AccessDeniedException;
}