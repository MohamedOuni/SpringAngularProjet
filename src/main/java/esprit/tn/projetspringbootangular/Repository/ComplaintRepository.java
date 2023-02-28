package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Categorie;
import esprit.tn.projetspringbootangular.Entities.Complaint;
import esprit.tn.projetspringbootangular.Entities.ComplaintStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint,Integer> {

    List<Complaint> findByCategorie(Categorie categorie);

    List<Complaint>  findByStatus(ComplaintStatus status);

    List<Complaint>  findByUser_Prenom(String prenom);

    //List<Complaint> OrderByCreated_atAsc();

    //List<Complaint> OrderByCreated_atDesc();
}
