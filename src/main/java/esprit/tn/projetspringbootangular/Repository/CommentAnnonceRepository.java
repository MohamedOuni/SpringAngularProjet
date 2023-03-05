package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.AnnonceMobilte;
import esprit.tn.projetspringbootangular.Entities.CommentAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentAnnonceRepository extends JpaRepository<CommentAnnonce, Integer> {


   /* List<CommentAnnonce> findCommentAnnonceByAnnonceId_Annonce( Integer id_Annonce);*/
}
