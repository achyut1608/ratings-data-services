package com.learn.micrsoservice.ratingsdataservices.service;

import com.learn.micrsoservice.ratingsdataservices.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingsService {

    public Ratings insertMovieRatings(Ratings ratings);

    public Ratings updateMovieRatings(Ratings ratings);

    public int deleteMovieRatings(String movieName);

    public List<Ratings> showAllMovieRatings();

    public Ratings showSpecificMovieRatings(String movieName);

}
