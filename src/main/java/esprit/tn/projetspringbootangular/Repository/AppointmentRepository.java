package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Appointment;
import esprit.tn.projetspringbootangular.Entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {


    List<Appointment> findByStudent_Username(String username);
}
