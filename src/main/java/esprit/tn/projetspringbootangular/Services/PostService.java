package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Integer addForumPost(Post forumPost, Integer id_user);



    public List<Post> getAllForumPosts();
    public Optional<Post> getForumPostById(Integer id);
    public Post updateForumPost(Integer idPost, Post forumPost,  Integer id_user);
    public boolean deleteForumPost(Integer id, Integer id_user);
}
