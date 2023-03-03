package esprit.tn.projetspringbootangular.Services;


import esprit.tn.projetspringbootangular.Entities.Complaint;
import esprit.tn.projetspringbootangular.Entities.ComplaintStatus;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServicesImp  implements IUserServices{

    private  final UserRepository userRepository;

    @Override
    public User addUser(User u) {
        return userRepository.save(u);
    }
}
