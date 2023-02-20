package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
