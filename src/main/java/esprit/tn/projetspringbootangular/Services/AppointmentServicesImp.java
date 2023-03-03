package esprit.tn.projetspringbootangular.Services;


import esprit.tn.projetspringbootangular.Entities.*;
import esprit.tn.projetspringbootangular.Repository.AppointmentRepository;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentServicesImp  implements  IAppointmentServices{

    private  final AppointmentRepository appointmentRepository;

    private  final UserRepository userRepository;

    private final  IEmailService iemailService;



    @Override
    public Appointment addAppointmentAndAssignToStudent(Appointment a) {
        User student = userRepository.findById(a.getStudent().getId_user()).orElse(null);
        a.setStudent(student);
        a.setStatus(AppointmentStatus.PENDING);
        iemailService.sendSimpleMail(a.getStudent().getEmail(), "Appointment", " Appointment !");
        return appointmentRepository.save(a);
    }

    @Override
    public List<Appointment> retrieveAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment retrieveAppointment(Integer idAppointment) {
        return appointmentRepository.findById(idAppointment).orElse(null);
    }

    @Override
    public Appointment updateAppointment(Appointment a) {
        return appointmentRepository.save(a);
    }

    @Override
    public void removeAppointment(Integer idAppointment) {
        appointmentRepository.deleteById(idAppointment);
    }

    @Override
    public Appointment assignAppointmentToUniversityOfficer(Integer idAppointment, Integer idUniversityOfficer) {
        Appointment appointment = appointmentRepository.findById(idAppointment).orElse(null);
        User universityOfficer = userRepository.findById(idUniversityOfficer).orElse(null);
        appointment.setUniversityOfficer(universityOfficer);
        return  appointmentRepository.save(appointment);
    }

    @Override
    public List<User> getAvailableUniversityOfficersbydate(Date date) {
        Date dateAppointment =date;  //  Date dateAppointment =new Date();

        try {
            dateAppointment = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(date));


        } catch (ParseException e) {

        }
        // Récupération de la liste de tous les agents universitaires
        List<User> UniversityOfficers = userRepository.findByRoles_role(EnumRole.Universite);
        // Récupération de la liste de tous les rendez-vous
        List<Appointment> appointments = appointmentRepository.findAll();

        List<User> notAvailableOfficers=new ArrayList<User>();
        for(Appointment a : appointments){
            if(a.getDate().compareTo(dateAppointment) ==0 )
            {
                notAvailableOfficers.add(a.getUniversityOfficer());
            }
        }
       UniversityOfficers.removeAll(notAvailableOfficers);

                return UniversityOfficers;
    }


}

