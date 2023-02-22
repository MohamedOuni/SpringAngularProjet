package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Post;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Entities.Vote;

import java.util.List;
import java.util.Optional;

public interface VoteService {

    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);

    public Vote addVote(Vote vote, Integer id_user, Post forumPost);

    public List<Vote> getAllVotes();
    public Integer getPostId();
    public Optional<Vote> getVoteById(Integer id);
    //public Vote addVote(Vote vote, Long userId, Comment comment);
}
