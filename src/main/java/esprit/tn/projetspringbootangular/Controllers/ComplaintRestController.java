package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.Categorie;
import esprit.tn.projetspringbootangular.Entities.Complaint;
import esprit.tn.projetspringbootangular.Entities.ComplaintStatus;
import esprit.tn.projetspringbootangular.Services.IComplaintServices;
import esprit.tn.projetspringbootangular.utils.BadWordFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complaint")
public class ComplaintRestController {
    private  final IComplaintServices iComplaintServices;


    @PostMapping("/add")
    Complaint addComplaint(@RequestBody Complaint  complaint){
        complaint.setDescription(BadWordFilter.getCensoredText(complaint.getDescription()));
        return iComplaintServices.addComplaint(complaint);
    }

    @PutMapping("/update")
    Complaint updateComplaint(@RequestBody Complaint complaint){
        complaint.setDescription(BadWordFilter.getCensoredText(complaint.getDescription()));
        return iComplaintServices.UpdateComplaint(complaint);
    }


    @GetMapping("/get/{id}")
    Complaint getComplaint(@PathVariable("id") Integer idComplaint){
        return  iComplaintServices.retrieveComplaint(idComplaint);
    }

    @GetMapping("/all")
    List<Complaint> getAllComplaints(){
        return  iComplaintServices.retrieveAllComplaints();
    }


    @DeleteMapping("/delete/{id}")
    void deleteComplaint(@PathVariable("id") Integer idComplaint){
        iComplaintServices.removeComplaint(idComplaint);
    }


    @PutMapping("/assignComplaintToStudent/{ComplaintId}/{StudentId}")
    @ResponseBody
    public void assignComplaintToStudent(@PathVariable("ComplaintId") Integer idC, @PathVariable("StudentId") Integer idS) {
        iComplaintServices.assignCompToStudent(idC,idS);
    }


    @GetMapping("/complaintByCategorie/{c}")
    public List<Complaint> findByCategorie(@PathVariable("c") Categorie categorie) {
        return iComplaintServices.findByCategorie(categorie);
    }


    @GetMapping("/complaintByStatus/{s}")
    public List<Complaint> findByStatus(@PathVariable("s") ComplaintStatus status) {
        return iComplaintServices.findByStatus(status);
    }


    @GetMapping("/find-Complaintwithpagination/{offset}/{pagesize}")
    public Page<Complaint> findComplaintwithPagination(@PathVariable ("offset")int offset, @PathVariable("pagesize")int pagesize ){
        return iComplaintServices.findwithPagination(offset, pagesize);

    }


    @GetMapping("/complaintByStudentPrenom/{name}")
    @ResponseBody
    public List<Complaint> findByStudentPrenom(@PathVariable ("name")String name){
        return iComplaintServices.findByUser_Prenom(name);
    }


    /*
    @GetMapping("/orderBydateAsc")
    List<Complaint> orderBydateAsc(){
        return  iComplaintServices.OrderByCreated_atAsc();
    }
    */

}
