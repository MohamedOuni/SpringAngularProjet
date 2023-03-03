package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.Appointment;
import esprit.tn.projetspringbootangular.Entities.Complaint;
import esprit.tn.projetspringbootangular.Entities.Role;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Repository.AppointmentRepository;
import esprit.tn.projetspringbootangular.Repository.RoleRepository;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import esprit.tn.projetspringbootangular.Services.IUserServices;
import esprit.tn.projetspringbootangular.utils.BadWordFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")

public class UserRestController {

    private final IUserServices iUserServices;
    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;
    private final RoleRepository roleRepository;

    @PostMapping("/add")
    User addUser(@RequestBody User user) {
        return iUserServices.addUser(user);
    }

}
