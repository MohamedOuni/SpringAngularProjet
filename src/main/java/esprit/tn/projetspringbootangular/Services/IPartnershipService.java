package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Partnership;

import java.util.List;

public interface IPartnershipService {
    void addPartnership(Partnership partnership);

    Partnership updatePartnership(Integer idPartnership, Partnership partnership);

    void removePartnership(Integer idPartnership);

    List<Partnership> retrievePartnership(Integer idPartnership);

    List<Partnership> getAllPartnership();
}
