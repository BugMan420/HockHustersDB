package com.example.tsi.izzy.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    private String title;
    private String description;
    private int release_year;
    private int rental_duration;
    private int length;
    private String rating;
    private String special_features;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)

    @JoinTable(name = "film_actor",
            joinColumns = {
                    @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id",
                            nullable = false, updatable = false)})
    @JsonIgnore
    private Set<Actor> actor = new HashSet<>();


    public Film(String title, String description, int release_year, int rental_duration, int length, double replacement_cost, String rating, String special_features){
        this.title=title;
        this.description=description;
        this.release_year=release_year;
        this.rental_duration=rental_duration;
        this.length=length;
        this.rating=rating;
        this.special_features=special_features;

    }

    public Film(){
    }

    public int getFilm_id() {
        return film_id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

}