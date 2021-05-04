package com.learn.micrsoservice.ratingsdataservices.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@ToString
@Entity
public class Ratings {

    @Id
    private String movieId;
    private String movieRatings;

}
