package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Dto.UniversityDto;
import esprit.tn.projetspringbootangular.Entities.Specialities;
import esprit.tn.projetspringbootangular.Entities.University;
import esprit.tn.projetspringbootangular.Services.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("university")
public class UniversityController {
    @Autowired
    private IUniversityService universityServices;

    @PostMapping("/add")
    void addUniversity(@RequestBody University university){
        universityServices.addUniversity(university);
    }

    @DeleteMapping("/delete/{id}")
    void deleteUniversity(@PathVariable("id") Integer idUniversity){
        universityServices.removeUniversity(idUniversity);
    }


    @PutMapping("/update/{id}")
    University updateUniversity(@PathVariable("id") Integer idUniversity , @RequestBody University university){
        return universityServices.updateUniversity(idUniversity, university);
    }

    @GetMapping("/get/{id}")
    List<University> getUniversity(@PathVariable("id") Integer idUniversity){
        return universityServices.retrieveUniversity(idUniversity);
    }

    @GetMapping ("/all")
    List<University> getUniversity(){
        return universityServices.getAllUniversity();
    }

    @GetMapping ("/allSpeciality/{speciality}")
    List<University> getUniversityBySpeciality(@PathVariable Specialities speciality){
        return universityServices.getUniversityBySpeciality(speciality);
    }
    @GetMapping ("/allAdresse/{adresse}")
    List<University> getUniversityByAdresse(@PathVariable  String adresse){
        return universityServices.getUniversityByAdress(adresse);
    }

    @GetMapping ("/allVille/{ville}")
    List<University> getUniversityByVille(@PathVariable  String ville){
        return universityServices.getUniversityByVille(ville);
    }

    @PostMapping()
    public UniversityDto addUniversityDto(UniversityDto university){
        return universityServices.addUniversityDto(university);
    }

    @GetMapping()
    public List<UniversityDto> retriveAllUniversityDto(){
        return universityServices.retrieveAllUniversityDto();
    }

}
