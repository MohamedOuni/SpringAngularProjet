package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Appointment;
import esprit.tn.projetspringbootangular.Entities.EnumRole;
import esprit.tn.projetspringbootangular.Entities.Role;
import esprit.tn.projetspringbootangular.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User,Integer>  {
    List<User> findByRoles_role(EnumRole role);

    List<User>  findByEmail(String email);
}
