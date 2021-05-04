package com.learn.micrsoservice.ratingsdataservices.controller;

import com.learn.micrsoservice.ratingsdataservices.entity.Ratings;
import com.learn.micrsoservice.ratingsdataservices.service.RatingsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/api/v1/ratings")
public class RatingsController {

    Logger LOGGER = LogManager.getLogger(RatingsController.class.getName());

    @Autowired
    RatingsService ratingsService;


    @GetMapping("/")
    public ResponseEntity<List<Ratings>> showAllMovieRatings(){
        try {
            LOGGER.info("showing all movie ratings");
            return new ResponseEntity<List<Ratings>>(ratingsService.showAllMovieRatings(), HttpStatus.OK);

        } catch (Exception ex){
            ex.printStackTrace();
            LOGGER.error(ex.getStackTrace());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"There is some problem");
        }
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Ratings> showSpecificMovieRatings(@PathVariable("movieId") String movieId) {
        try {
            LOGGER.info("showing specific Movie ratings : " + movieId);
            return new ResponseEntity<Ratings>(ratingsService.showSpecificMovieRatings(movieId), HttpStatus.OK);
        } catch(Exception ex){
            ex.printStackTrace();
            LOGGER.error(ex.getStackTrace());
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"There is some problem while fetching single movie Ratings");
        }
    }


    @PostMapping("/")
    public ResponseEntity<Ratings> insertMovieRatings(@RequestBody Ratings ratings){
        try {
            System.out.println("inside the insert movie ratings controller");
            LOGGER.info("Saving movie ratings : " + ratings);
            return new ResponseEntity<Ratings>(ratingsService.insertMovieRatings(ratings),HttpStatus.OK);
        } catch(Exception ex){
            ex.printStackTrace();
            LOGGER.error(ex.getStackTrace());
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"There is some problem while inserting movie ratings");
        }
    }

    @PutMapping("/{ratings}")
    public ResponseEntity<Ratings> updateMovieRatings(@PathVariable String movieName,@RequestBody Ratings ratings){
        try {
            LOGGER.info("updating movie : " + movieName + " ratings  : " + ratings);
            return new ResponseEntity<Ratings>(ratingsService.updateMovieRatings(ratings),HttpStatus.OK);
        } catch(Exception ex){
            LOGGER.error(ex.getStackTrace());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"There is some problem while updating movie ratings");
        }

    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Integer> deleteMovieRatings(@PathVariable("movieId") String movieId) {
        try {
            System.out.println("inside the delete movie ratings controller");
            LOGGER.info("in controller movieName : " +movieId);
            return new ResponseEntity<Integer>(ratingsService.deleteMovieRatings(movieId),HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error(ex.getStackTrace());
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"There is some problem");
        }
    }
}