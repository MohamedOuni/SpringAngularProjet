package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.Rating;
import esprit.tn.projetspringbootangular.Services.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("rating")
public class RatingController {
    @Autowired
    private IRatingService ratingServices;

    @PostMapping("/add")
    void addRating(@RequestBody Rating rating){
        ratingServices.addRating(rating);
    }

    @DeleteMapping("/delete/{id}")
    void deleteRating(@PathVariable("id") Integer idRating){
        ratingServices.removeRating(idRating);
    }


    @PutMapping("/update/{id}")
    Rating updateRating(@PathVariable("id") Integer idRating , @RequestBody Rating rating){
        return ratingServices.updateRating(idRating, rating);
    }

    @GetMapping("/get/{id}")
    List<Rating> getRating(@PathVariable("id") Integer idRating){
        return ratingServices.retrieveRating(idRating);
    }

    @GetMapping ("/all")
    List<Rating> getAllRating(){
        return ratingServices.getAllRating();
    }

}
