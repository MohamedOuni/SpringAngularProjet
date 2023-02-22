package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}