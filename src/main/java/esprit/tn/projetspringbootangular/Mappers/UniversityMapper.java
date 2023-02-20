package esprit.tn.projetspringbootangular.Mappers;

import esprit.tn.projetspringbootangular.Dto.UniversityDto;
import esprit.tn.projetspringbootangular.Entities.University;

public class UniversityMapper {
    public static UniversityDto mapToDto(University university) {
        UniversityDto universityDto= UniversityDto.builder()
                .idUniversity(university.getIdUniversity())
                .name(university.getName())
                .email(university.getEmail())
                .doyen(university.getDoyen())
                .adresse(university.getAdresse())
                .ville(university.getVille())
                .doyen(university.getDoyen())
                .speciality(university.getSpeciality())
                .Representative_Name(university.getPartnership().getRepresentative_Name())
                .Representative_Email(university.getPartnership().getRepresentative_Email())
                .build();
        return universityDto;
    }

    public static University mapToEntity(UniversityDto universityDto){
        University university = University.builder()
                .name( universityDto.getName())
                .email( universityDto.getEmail())
                .doyen( universityDto.getDoyen())
                .adresse( universityDto.getAdresse())
                .ville( universityDto.getVille())
                .doyen( universityDto.getDoyen())
                .speciality( universityDto.getSpeciality())
                .build();
        return university;
    }

}
