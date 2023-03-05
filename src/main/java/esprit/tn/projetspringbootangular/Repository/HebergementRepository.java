package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.AnnonceHeberge;
import esprit.tn.projetspringbootangular.Entities.AnnonceMobilte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HebergementRepository extends JpaRepository<AnnonceHeberge, Integer> {



    @Query("SELECT a FROM AnnonceHeberge a WHERE a.adresse LIKE %:adresse%")
    List<AnnonceHeberge>  findAnnonceHebergeByAdresseIgnoreCase   (@Param("adresse") String titre);

    List<AnnonceHeberge>  findAnnonceHebergeByDatePub(@Param("datePub") LocalDate datePub);
}
