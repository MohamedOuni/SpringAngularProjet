package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Dto.UniversityDto;
import esprit.tn.projetspringbootangular.Entities.Specialities;
import esprit.tn.projetspringbootangular.Entities.University;

import java.util.List;

public interface IUniversityService {
    void addUniversity(University univ);

    University updateUniversity(Integer idUniversity, University univ);

    void removeUniversity(Integer idUniversity);

    List<University> retrieveUniversity(Integer idUniversity);

    List<University> getAllUniversity();


    UniversityDto addUniversityDto(UniversityDto universityDto);

    List<UniversityDto> retrieveAllUniversityDto();

    List<University> getUniversityBySpeciality(Specialities speciality);

    List<University> getUniversityByAdress(String adresse);


    List<University> getUniversityByVille(String ville);


}
