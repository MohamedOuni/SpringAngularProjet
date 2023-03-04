package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Dto.PartnershipDto;
import esprit.tn.projetspringbootangular.Dto.UniversityDto;
import esprit.tn.projetspringbootangular.Entities.Partnership;
import esprit.tn.projetspringbootangular.Entities.Status;

import java.util.List;

public interface IPartnershipService {
    void addPartnership(Partnership partnership);

    Partnership updatePartnership(Integer idPartnership, Partnership partnership);

    void removePartnership(Integer idPartnership);

    List<Partnership> retrievePartnership(Integer idPartnership);

    List<Partnership> getAllPartnership();
    PartnershipDto addPartnershipDto(PartnershipDto partnershipDto);

    List<PartnershipDto> retrieveAllPartnershipDto();

   // PartnershipDto addPartnershipAndAssignToUniversity(PartnershipDto partnershipDto);

  //  List<Partnership> getByPackage(Package partnerShip_Package);

    List<Partnership> getByStatus(Status status);

    Partnership assignPartnershipToUniversity(Integer idPartnership, Integer idUniversity);
}