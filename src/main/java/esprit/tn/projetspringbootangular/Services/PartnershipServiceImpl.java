package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Partnership;
import esprit.tn.projetspringbootangular.Repository.PartnershipRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service("partnership")
public class PartnershipServiceImpl implements IPartnershipService {

    private final PartnershipRepository partnershipRepository;

    @Autowired
    public PartnershipServiceImpl(PartnershipRepository partnershipRepository) {
        this.partnershipRepository = partnershipRepository;
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
}
