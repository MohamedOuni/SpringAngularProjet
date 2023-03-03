package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Categorie;
import esprit.tn.projetspringbootangular.Entities.Complaint;
import esprit.tn.projetspringbootangular.Entities.ComplaintStatus;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Repository.ComplaintRepository;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComplaintServicesImp implements IComplaintServices {
    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;

    private final  IEmailService iemailService;

    @Override
    public List<Complaint> retrieveAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint addComplaintAndAssignToUser(Complaint c) {
        User user = userRepository.findById(c.getUser().getId_user()).orElse(null);
        c.setUser(user);
        c.setCreated_at(new Date());
        c.setStatus(ComplaintStatus.INPROGRESS);
        iemailService.sendSimpleMail(c.getUser().getEmail(), "Complaint", "Complaint!");
        return complaintRepository.save(c);
    }

    @Override
    public Complaint retrieveComplaint(Integer idComplaint) {
        return complaintRepository.findById(idComplaint).orElse(null);
    }

    @Override
    public Complaint UpdateComplaint(Complaint c) {
        return complaintRepository.save(c);
    }

    @Override
    public void removeComplaint(Integer idComplaint) {
      complaintRepository.deleteById(idComplaint);
    }

    @Override
    public List<Complaint> findByCategorie(Categorie categorie) {
        return complaintRepository.findByCategorie(categorie);
    }

    @Override
    public List<Complaint> findByStatus(ComplaintStatus status) {
        return complaintRepository.findByStatus(status);
    }

    @Override
    public Page<Complaint> findwithPagination(int offset, int pagesize) {
        Page<Complaint> c = complaintRepository.findAll(PageRequest.of(offset, pagesize));
        return c;
    }

    @Override
    public List<Complaint> findByUser_Username(String username) {
        return  complaintRepository.findByUser_Username(username);
    }

    @Scheduled(cron = "0 0 8 * * MON,WED")
    @Override
    public void retrieveComplaintsINPROGRESS() {
        List<Complaint> complaints = this.complaintRepository.findByStatus(ComplaintStatus.INPROGRESS);
        for(Complaint c : complaints){
            if (c.getCreated_at().before(new Date())) {
                log.info("List of pending claims: " + c.getTitle() +
                        " : Student : " + c.getUser().getUsername() +
                        " : Created-At : " + c.getCreated_at());
            }
        }
    }
}
