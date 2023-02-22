package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Post;
import esprit.tn.projetspringbootangular.Entities.TypeVote;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Entities.Vote;
import esprit.tn.projetspringbootangular.Exception.PostNotFoundException;
import esprit.tn.projetspringbootangular.Exception.SpringForumException;
import esprit.tn.projetspringbootangular.Repository.CommentRepository;
import esprit.tn.projetspringbootangular.Repository.PostRepository;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import esprit.tn.projetspringbootangular.Repository.VoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VoteServiceImp implements VoteService {
    @Autowired
    VoteRepository voteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser) {
        return voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, currentUser);
    }

    @Override
    public Vote addVote(Vote vote, Integer idUser, Post post) {
        User user = userRepository.findById(idUser).get();
        Optional<Vote> existingVote = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, user);
        if (existingVote.isPresent()) {
            voteRepository.delete(existingVote.get());
        }
        vote.setUser(user);
        vote.setPost(post);
        return voteRepository.save(vote);
    }


    @Override
    public Integer getPostId() {
        return null;
    }


    @Override
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public Optional<Vote> getVoteById(Integer id) {
        return voteRepository.findById(id);
    }

    @Transactional
    public void vote(Vote vote, User user) {

        Post post = postRepository.findById(vote.getPost().getPostId())
                .orElseThrow(() -> new PostNotFoundException("Post Not Found with ID - " + vote.getPost().getPostId()));
        //Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, autService.getCurrentUser());
        Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, user);
        if (voteByPostAndUser.isPresent() &&
                voteByPostAndUser.get().getVoteType()
                        .equals(vote.getVoteType())) {
            throw new SpringForumException("You have already "
                    + vote.getVoteType() + "'d for this post");
        }
        if (TypeVote.UPVOTE.equals(vote.getVoteType())) {

            post.setVoteCount(post.getVoteCount() + 1);
        } else {
            post.setVoteCount(post.getVoteCount() - 1);
        }
        //voteRepository.save(mapToVote(voteDto, post));
        postRepository.save(post);
    }
}
    /*@Override
        public Vote addVote(Vote vote, Integer id_user, Comment comment) {
        User user = userRepository.findById(idUser).get();
        Optional<Vote> existingVote = voteRepository.findByUserAndComment(user, comment);
        if (existingVote.isPresent()) {
            voteRepository.delete(existingVote.get());
        }
        vote.setUser(user);
        vote.setComment(comment);
        return voteRepository.save(vote);
    }

    @Override
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }
    @Override
    public Optional<Vote> getVoteById(Integer id) {
        return voteRepository.findById(id);
    }*/
