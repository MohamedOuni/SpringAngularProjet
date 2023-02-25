package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Partnership;
import esprit.tn.projetspringbootangular.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface PartnershipRepository  extends JpaRepository<Partnership, Integer> {
    List<Partnership> findByIdPartnership(Integer idPartnership);

  //  List<Partnership> findByPartnerShip_Package(Package partnerShip_Package);

    List<Partnership> findByStatut(Status status);
    int countByArchiveIsTrueAndAndUniversityIdUniversity(Integer idUniversity);


}
