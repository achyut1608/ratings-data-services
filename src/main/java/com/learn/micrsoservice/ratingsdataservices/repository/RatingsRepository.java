package com.learn.micrsoservice.ratingsdataservices.repository;

import com.learn.micrsoservice.ratingsdataservices.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings,String> {
}
