package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Categorie;
import esprit.tn.projetspringbootangular.Entities.Complaint;
import esprit.tn.projetspringbootangular.Entities.ComplaintStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IComplaintServices {
    List<Complaint> retrieveAllComplaints();

    Complaint  addComplaint(Complaint c);


    Complaint retrieveComplaint(Integer idComplaint);

    Complaint  UpdateComplaint(Complaint c);


    void removeComplaint(Integer idComplaint);

    //Complaint assignCompToStudent(Integer idComplaint,Integer idUser);

    List<Complaint> findByCategorie(Categorie categorie);

    List<Complaint>  findByStatus(ComplaintStatus status);

    Page<Complaint> findwithPagination(int offset, int pagesize);

    List<Complaint>  findByUser_Username(String username);

    void  retrieveComplaintsINPROGRESS();
}
