package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Entities.Vote;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import esprit.tn.projetspringbootangular.Services.CommentServiceImp;
import esprit.tn.projetspringbootangular.Services.PostServiceImp;
import esprit.tn.projetspringbootangular.Services.VoteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {
    @Autowired
    VoteServiceImp voteService;
    @Autowired
    PostServiceImp postService;
    @Autowired
    CommentServiceImp commentService;
    @Autowired
    UserRepository userRepository;


    @GetMapping
    public List<Vote> getAllVotes()
    {return voteService.getAllVotes();}


    @PostMapping("/{userId}/vote")
    public ResponseEntity<Void> vote(@RequestBody Vote vote, @PathVariable("userId") Integer userId) {
        User user= userRepository.findById(userId).get();
        voteService.vote(vote, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
    /*@PostMapping("/comments/{commentId}/{userId}")
    public ResponseEntity<Vote> addVoteForComment(@PathVariable("commentId") Integer commentId, @RequestBody Vote vote,@PathVariable("userId")Integer userId) {
        Optional<Comment> comment = commentService.getCommentById(commentId);
        if (comment.isPresent()) {
            Vote addedVote = voteService.addVote(vote, userId, .get());
            return ResponseEntity.ok(addedVote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVoteById(@PathVariable Integer id) {
        Optional<Vote> vote = voteService.getVoteById(id);
        return vote.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> votes = voteService.getAllVotes();
        return ResponseEntity.ok(votes);*/


