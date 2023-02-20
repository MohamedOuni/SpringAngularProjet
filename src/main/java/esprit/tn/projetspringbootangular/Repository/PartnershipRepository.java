package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Partnership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnershipRepository  extends JpaRepository<Partnership, Integer> {
    List<Partnership> findByIdPartnership(Integer idPartnership);
}
