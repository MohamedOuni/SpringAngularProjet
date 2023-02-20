package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Dto.UniversityDto;
import esprit.tn.projetspringbootangular.Entities.University;
import esprit.tn.projetspringbootangular.Mappers.UniversityMapper;
import esprit.tn.projetspringbootangular.Repository.UniversityRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service("university")
public class UniversityServiceImpl implements IUniversityService   {

    final UniversityRepository universityRepository;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public void addUniversity(University univ) {
        universityRepository.save(univ);
    }

    @Override
    public University updateUniversity(Integer idUniversity, University univ) {
        List<University> newUniversity = universityRepository.findByIdUniversity(idUniversity);
        if (univ.getName()!= null)
            newUniversity.get(0).setName(univ.getName());
        return universityRepository.save(newUniversity.get(0));
    }

    @Override
    public void removeUniversity(Integer idUniversity) {
        universityRepository.deleteById(idUniversity);
    }

    @Override
    public List<University> retrieveUniversity(Integer idUniversity) {
        return universityRepository.findByIdUniversity(idUniversity);
    }

    @Override
    public List<University> getAllUniversity() {
        List<University> universities = new ArrayList<>();
        universityRepository.findAll().forEach(universities::add);
        return universities;
    }

    @Override
    public UniversityDto addUniversityDto(UniversityDto universityDto) {
        University university= universityRepository.save(UniversityMapper.mapToEntity(universityDto));
        return UniversityMapper.mapToDto(university);
    }

    @Override
    public List<UniversityDto> retrieveAllUniversityDto() {
        return universityRepository.findAll()
                .stream()
                .map(university -> UniversityMapper.mapToDto(university))
                .collect(Collectors.toList());
    }
}
