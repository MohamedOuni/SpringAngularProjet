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


    @PutMapping("/addComplaintAndAssignToUser")
    Complaint addComplaintAndAssignToUser(@RequestBody Complaint  complaint){
        complaint.setDescription(BadWordFilter.getCensoredText(complaint.getDescription()));
        return iComplaintServices.addComplaintAndAssignToUser(complaint);
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


    @GetMapping("/complaintByCategorie/{c}")
    public List<Complaint> findByCategorie(@PathVariable("c") Categorie categorie) {
        return iComplaintServices.findByCategorie(categorie);
    }


    @GetMapping("/complaintByStatus/{s}")
    public List<Complaint> findByStatus(@PathVariable("s") ComplaintStatus status) {
        return iComplaintServices.findByStatus(status);
    }


    @GetMapping("/findComplaintwithpagination/{offset}/{pagesize}")
    public Page<Complaint> findComplaintwithPagination(@PathVariable ("offset")int offset, @PathVariable("pagesize")int pagesize ){
        return iComplaintServices.findwithPagination(offset, pagesize);

    }

    @GetMapping("/complaintByUsername/{name}")
    public List<Complaint> findByUsername(@PathVariable("name") String name) {
        return iComplaintServices.findByUser_Username(name);
    }



}
