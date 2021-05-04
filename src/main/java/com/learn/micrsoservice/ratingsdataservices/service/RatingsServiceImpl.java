package com.learn.micrsoservice.ratingsdataservices.service;

import com.learn.micrsoservice.ratingsdataservices.entity.Ratings;
import com.learn.micrsoservice.ratingsdataservices.repository.RatingsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RatingsServiceImpl implements RatingsService {

    Logger LOGGER = LogManager.getLogger(RatingsServiceImpl.class.getName());
    @Autowired
    RatingsRepository ratingsRepository;

    @Override
    @Transactional
    public Ratings insertMovieRatings(Ratings ratings) {
        System.out.println("insertMovieratings service");
        Ratings ratings1 = ratingsRepository.save(ratings);
            LOGGER.info("Object saved Successfully");

        return ratings1;
    }

    @Override
    @Transactional
    public Ratings updateMovieRatings(Ratings ratings) {
        return null;
    }

    @Override
    @Transactional
    public int deleteMovieRatings(String movieId) {
           try {
               ratingsRepository.deleteById(movieId);
            return 1;
           } catch (Exception ex){
               ex.printStackTrace();
           }
           return -1;
    }

    @Override
    public List<Ratings> showAllMovieRatings() {
        List<Ratings> list = ratingsRepository.findAll();
            LOGGER.info("get All Movie Successfully");
        return list;
    }

    @Override
    public Ratings showSpecificMovieRatings(String movieName) {
        Ratings ratings =  ratingsRepository.findById(movieName).get();
        LOGGER.info("fetched specific movie successfully");
        return ratings;
    }
}
