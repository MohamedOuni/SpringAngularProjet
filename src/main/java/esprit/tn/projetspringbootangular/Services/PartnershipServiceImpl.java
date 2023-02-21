package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Dto.PartnershipDto;
import esprit.tn.projetspringbootangular.Entities.Partnership;
import esprit.tn.projetspringbootangular.Entities.University;
import esprit.tn.projetspringbootangular.Mappers.PartnershipMapper;
import esprit.tn.projetspringbootangular.Repository.PartnershipRepository;
import esprit.tn.projetspringbootangular.Repository.UniversityRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service("partnership")
public class PartnershipServiceImpl implements IPartnershipService {

     final PartnershipRepository partnershipRepository;
     final UniversityRepository universityRepository;

    @Autowired
    public PartnershipServiceImpl(PartnershipRepository partnershipRepository, UniversityRepository universityRepository) {
        this.partnershipRepository = partnershipRepository;
        this.universityRepository = universityRepository;
    }

    @Override
    public void addPartnership(Partnership partnership) {
        partnershipRepository.save(partnership);
    }

    @Override
    public Partnership updatePartnership(Integer idPartnership, Partnership partnership) {
        List<Partnership> newPartnership = partnershipRepository.findByIdPartnership(idPartnership);
        if (partnership.getRepresentative_Name()!= null)
            newPartnership.get(0).setRepresentative_Name(partnership.getRepresentative_Name());
        return partnershipRepository.save(newPartnership.get(0));
    }

    @Override
    public void removePartnership(Integer idPartnership) {
        partnershipRepository.deleteById(idPartnership);

    }

    @Override
    public List<Partnership> retrievePartnership(Integer idPartnership) {
        return partnershipRepository.findByIdPartnership(idPartnership);
    }

    @Override
    public List<Partnership> getAllPartnership() {
        List<Partnership> partnerships = new ArrayList<>();
        partnershipRepository.findAll().forEach(partnerships::add);
        return partnerships;
    }

    @Override
    public PartnershipDto addPartnershipDto(PartnershipDto partnershipDto) {
        Partnership partnership= partnershipRepository.save(PartnershipMapper.mapToEntity(partnershipDto));
        return PartnershipMapper.mapToDto(partnership);
    }

    @Override
    public List<PartnershipDto> retrieveAllPartnershipDto() {
        return partnershipRepository.findAll()
                .stream()
                .map(partnership -> PartnershipMapper.mapToDto(partnership))
                .collect(Collectors.toList());
    }

    @Override
    public PartnershipDto addPartnershipAndAssignToUniversity(PartnershipDto partnershipDto) {
        University university = universityRepository
                .findByNameAndEmailAndAdresseAndVilleAndDoyen(
                        partnershipDto.getName(),
                        partnershipDto.getEmail(),
                        partnershipDto.getAdresse(),
                        partnershipDto.getVille(),
                        partnershipDto.getDoyen());

    }
}
