package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Rating;

import java.util.List;

public interface IRatingService {
    void addRating(Rating rating);

    Rating updateRating(Integer idRating, Rating rating);

    void removeRating(Integer idRating);

    List<Rating> retrieveRating(Integer idRating);

    List<Rating> getAllRating();
}
