package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Specialities;
import esprit.tn.projetspringbootangular.Entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
    List<University> findByIdUniversity(Integer idUniversity);

    List<University> findBySpeciality(Specialities speciality);


}
