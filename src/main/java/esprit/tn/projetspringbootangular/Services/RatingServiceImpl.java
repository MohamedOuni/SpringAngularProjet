package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Rating;
import esprit.tn.projetspringbootangular.Repository.RatingRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service("rating")
public class RatingServiceImpl implements IRatingService {

    final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(Integer idRating, Rating rating) {
        List<Rating> newRating = ratingRepository.findByIdRating(idRating);
        if (rating.getNb_stars()!= 0)
            newRating.get(0).setNb_stars(rating.getNb_stars());
        return ratingRepository.save(newRating.get(0));
    }

    @Override
    public void removeRating(Integer idRating) {
        ratingRepository.deleteById(idRating);
    }

    @Override
    public List<Rating> retrieveRating(Integer idRating) {
        return ratingRepository.findByIdRating(idRating);
    }

    @Override
    public List<Rating> getAllRating() {
        List<Rating> ratings = new ArrayList<>();
        ratingRepository.findAll().forEach(ratings::add);
        return ratings;
    }
}
