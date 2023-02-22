package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.Comment;
import esprit.tn.projetspringbootangular.Entities.Post;
import esprit.tn.projetspringbootangular.Services.CommentServiceImp;
import esprit.tn.projetspringbootangular.Services.PostServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentController {
    @Autowired
    private CommentServiceImp commentService;
    @Autowired
    private PostServiceImp postService;

    @GetMapping("")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "id") Integer id) {
        Optional<Comment> comment = commentService.getCommentById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{userId}/{postId}")
    public Comment addComment(@RequestBody Comment comment, @PathVariable("userId") Integer userId, @PathVariable("postId") Integer postId) {
        Post forumPost = postService.getForumPostById(postId).get();
        return commentService.addComment(comment, userId, forumPost);
    }

    @PutMapping("/{id}/{idUser}")
    public ResponseEntity<Comment> updateComment(@PathVariable(value = "id") Integer id, @RequestBody Comment newComment,@PathVariable("idUser") Integer idUser) throws AccessDeniedException {
        Comment updatedComment = commentService.updateComment(id, newComment,idUser);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}/{idUser}")
    public ResponseEntity<Void> deleteComment(@PathVariable("id") Integer id, @PathVariable("idUser") Integer idUser) throws AccessDeniedException {
        commentService.deleteComment(id,idUser);
        return ResponseEntity.noContent().build();
    }
}