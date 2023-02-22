package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.Post;
import esprit.tn.projetspringbootangular.Services.PostServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/forumPosts")
public class PostController {
    @Autowired
    PostServiceImp postService;



    @PostMapping("/addPost/{id}")
    public Integer addForumPost(@RequestBody Post post, @PathVariable("id") Integer id) {
        return postService.addForumPost(post, id);

    }


    @GetMapping
    public List<Post> getAllForumPosts() {
        return postService.getAllForumPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getForumPostById(@PathVariable("id") Integer id) {
        Optional<Post> forumPost = postService.getForumPostById(id);
        if (!forumPost.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(forumPost.get());
    }

    @PutMapping("/{id}/{idUser}")
    public ResponseEntity<Post> updateForumPost(@PathVariable("id") Integer id,
                                                @RequestBody Post forumPost,
                                                @PathVariable("idUser")  Integer id_user) {
        Post updatedForumPost = postService.updateForumPost(id, forumPost, id_user);
        if (updatedForumPost == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedForumPost);
    }

    @DeleteMapping("/{id}/{idUser}")
    public ResponseEntity<Void> deleteForumPost(@PathVariable Integer id,
                                                @PathVariable("idUser")  Integer id_user) {
        boolean deleted = postService.deleteForumPost(id, id_user);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
