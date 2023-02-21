package esprit.tn.projetspringbootangular.Mappers;

import esprit.tn.projetspringbootangular.Dto.PartnershipDto;
import esprit.tn.projetspringbootangular.Dto.UniversityDto;
import esprit.tn.projetspringbootangular.Entities.Partnership;
import esprit.tn.projetspringbootangular.Entities.University;

public class PartnershipMapper {
    public static PartnershipDto mapToDto(Partnership partnership) {
        PartnershipDto partnershipDto = PartnershipDto.builder()
                .idPartnership(partnership.getIdPartnership())
                .Representative_Name(partnership.getRepresentative_Name())
                .Representative_Email(partnership.getRepresentative_Email())
                .partnerShip_Package(partnership.getPartnerShip_Package())
                .statut(partnership.getStatut())
                .PartnershipDate(partnership.getPartnershipDate())
                .archive(partnership.getArchive())
                .idUniversity(partnership.getUniversity().getIdUniversity())
                .name(partnership.getUniversity().getName())
                .email(partnership.getUniversity().getEmail())
                .doyen(partnership.getUniversity().getDoyen())
                .adresse(partnership.getUniversity().getAdresse())
                .ville(partnership.getUniversity().getVille())
                .doyen(partnership.getUniversity().getDoyen())
                .build();
        return partnershipDto;
    }

    public static Partnership mapToEntity(PartnershipDto partnershipDto){
        Partnership partnership = Partnership.builder()
                .idPartnership(partnershipDto.getIdPartnership())
                .Representative_Name(partnershipDto.getRepresentative_Name())
                .Representative_Email(partnershipDto.getRepresentative_Email())
                .partnerShip_Package(partnershipDto.getPartnerShip_Package())
                .statut(partnershipDto.getStatut())
                .PartnershipDate(partnershipDto.getPartnershipDate())
                .archive(partnershipDto.getArchive())
                .build();
        return partnership;
    }
}
