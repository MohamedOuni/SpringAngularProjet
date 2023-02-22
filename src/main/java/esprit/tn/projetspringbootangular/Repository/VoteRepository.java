package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Post;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Integer> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);


}