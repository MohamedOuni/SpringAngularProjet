package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}

