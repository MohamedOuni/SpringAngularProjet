package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.Partnership;
import esprit.tn.projetspringbootangular.Services.IPartnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("partnership")
public class PartnershipController {
    @Autowired
    private IPartnershipService partnershipServices;

    @PostMapping("/add")
    void addPartnership(@RequestBody Partnership partnership){
        partnershipServices.addPartnership(partnership);
    }

    @DeleteMapping("/delete/{id}")
    void deletePartnership(@PathVariable("id") Integer idPartnership){
        partnershipServices.removePartnership(idPartnership);
    }


    @PutMapping("/update/{id}")
    Partnership updatePartnership(@PathVariable("id") Integer idPartnership , @RequestBody Partnership partnership){
        return partnershipServices.updatePartnership(idPartnership, partnership);
    }

    @GetMapping("/get/{id}")
    List<Partnership> getPartnership(@PathVariable("id") Integer idPartnership){
        return partnershipServices.retrievePartnership(idPartnership);
    }

    @GetMapping ("/all")
    List<Partnership> getPartnership(){
        return partnershipServices.getAllPartnership();
    }



}
