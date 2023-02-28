package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.Appointment;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Services.IAppointmentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentRestController {
    private  final IAppointmentServices iAppointmentServices;

    @PutMapping("/add&AssignToStudent")
    Appointment addAppointmentAndAssignToStudent(@RequestBody Appointment appointment){
        return iAppointmentServices.addAppointmentAndAssignToStudent(appointment);
    }

    @PutMapping("/update")
    Appointment updateAppointment(@RequestBody Appointment appointment){
        return iAppointmentServices.updateAppointment(appointment);
    }


    @GetMapping("/get/{id}")
    Appointment getAppointment(@PathVariable("id") Integer idAppointment){
        return  iAppointmentServices.retrieveAppointment(idAppointment);
    }

    @GetMapping("/all")
    List<Appointment> getAllAppointments(){
        return iAppointmentServices.retrieveAllAppointments();
    }


    @DeleteMapping("/delete/{id}")
    void deleteAppointment(@PathVariable("id") Integer idAppointment){
        iAppointmentServices.removeAppointment(idAppointment);
    }


    @PutMapping("/assignAppointmentToUnivOfficer/{AppointmentId}/{UnivOfficerId}")
    @ResponseBody
    public void assignAppointmentToUniversityOfficer(@PathVariable("AppointmentId") Integer idAppointment, @PathVariable("UnivOfficerId") Integer idUnivOfficer) {
        iAppointmentServices.assignAppointmentToUniversityOfficer(idAppointment,idUnivOfficer);
    }



    @GetMapping("/getAvailableUniversityOfficersbydate/{dateA}")
    List<User> getAvailableUniversityOfficersbydate(@PathVariable("dateA") Date date){
        return iAppointmentServices.getAvailableUniversityOfficersbydate(date);
    }

}
