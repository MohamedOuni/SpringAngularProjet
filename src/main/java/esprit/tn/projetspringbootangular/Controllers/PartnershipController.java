package esprit.tn.projetspringbootangular.Controllers;

import com.itextpdf.text.DocumentException;
import esprit.tn.projetspringbootangular.Dto.PartnershipDto;
import esprit.tn.projetspringbootangular.Dto.UniversityDto;
import esprit.tn.projetspringbootangular.Entities.EmailDetails;
import esprit.tn.projetspringbootangular.Entities.Partnership;
import esprit.tn.projetspringbootangular.Entities.Status;
import esprit.tn.projetspringbootangular.Entities.University;
import esprit.tn.projetspringbootangular.Services.EmailServiceImpl;
import esprit.tn.projetspringbootangular.Services.IPartnershipService;
import esprit.tn.projetspringbootangular.pdf.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@RestController
@RequestMapping("partnership")
public class PartnershipController {
    @Autowired
    private IPartnershipService partnershipServices;

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping("/add")
    void addPartnership(@RequestBody Partnership partnership){
        partnershipServices.addPartnership(partnership);
       //0 emailService.sendSimpleMail();
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
    List<Partnership> getAllPartnership(){
        return partnershipServices.getAllPartnership();
    }

  /* @PostMapping("/addAndAssignPartnershipToUniversity")
    public PartnershipDto addPartnershipAndAssignToUniversity(PartnershipDto partnershipDto){
        return partnershipServices.addPartnershipAndAssignToUniversity(partnershipDto);
    }*/



    @PostMapping("/addPartnerDto")
    public PartnershipDto addUPartnershipDto(@RequestBody  PartnershipDto partnershipDto){

        return partnershipServices.addPartnershipDto(partnershipDto);
    }

    @GetMapping("/getPartnershipDto")
    public List<PartnershipDto> retriveAllPartnershipDto(){
        return partnershipServices.retrieveAllPartnershipDto();
    }

   /* @GetMapping ("/allPackage/{package}")
    List<Partnership> getPartnershipByPackage(@PathVariable  Package partnerShip_Package){
        return partnershipServices.getByPackage(partnerShip_Package);
    }*/

    @GetMapping ("/allStatus/{statut}")
    List<Partnership> getPartnershipByStatus(@PathVariable Status status){
        return partnershipServices.getByStatus(status);
    }

   @GetMapping("/pdf/partnerships")
    public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);

        List<Partnership> partnerships = partnershipServices.getAllPartnership();

        PDFGenerator generator = new PDFGenerator();
        generator.setPartnerships(partnerships);
        generator.generate(response);

    }

    @PutMapping("affecterUniversity/{idPartnership}/{idUniversity}")
    Partnership affecterUniversity(@PathVariable("idPartnership")Integer idPartnership,@PathVariable("idUniversity") Integer idUniversity)
    {
        return partnershipServices.assignPartnershipToUniversity(idUniversity, idUniversity);
    }


}
