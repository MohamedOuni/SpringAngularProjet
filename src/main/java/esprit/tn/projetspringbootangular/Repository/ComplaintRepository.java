package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Categorie;
import esprit.tn.projetspringbootangular.Entities.Complaint;
import esprit.tn.projetspringbootangular.Entities.ComplaintStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint,Integer> {

    List<Complaint> findByCategorie(Categorie categorie);

    List<Complaint>  findByStatus(ComplaintStatus status);

    List<Complaint>  findByUser_Username(String username);








}
