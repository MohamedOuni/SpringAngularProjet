package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Appointment;
import esprit.tn.projetspringbootangular.Entities.User;

import java.util.Date;
import java.util.List;

public interface IAppointmentServices {

    List<Appointment> retrieveAllAppointments();

    Appointment addAppointmentAndAssignToStudent(Appointment a);

    Appointment updateAppointment(Appointment a);

    Appointment retrieveAppointment(Integer idAppointment);

    void removeAppointment(Integer idAppointment);

    Appointment assignAppointmentToUniversityOfficer(Integer idAppointment, Integer idUniversityOfficer);

    List<User> getAvailableUniversityOfficersbydate(Date date);

}
