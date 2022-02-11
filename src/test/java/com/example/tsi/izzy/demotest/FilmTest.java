package com.example.tsi.izzy.demotest;

import com.example.tsi.izzy.demo.Actor;
import com.example.tsi.izzy.demo.Film;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmTest {

 Film filmTest = new Film("TestName","Test Description",1992,
         82,"PG","TestFeatures");

    @Test
    void getFilm_id() {
        assertEquals(0,filmTest.getFilm_id(),"This test has failed");
    }

    @Test
    void getTitle() {
        assertEquals("TestName",filmTest.getTitle(),"This test has failed");
    }

    @Test
    void setTitle() {
        filmTest.setTitle("Title2");
        assertEquals("Title2",filmTest.getTitle(),"This test has failed");
    }

    @Test
    void getDescription() {
        assertEquals("Test Description",filmTest.getDescription(),"This test has failed");
    }

    @Test
    void setDescription() {
        filmTest.setDescription("DescriptionChange");
        assertEquals("DescriptionChange",filmTest.getDescription(),"This test has failed");
    }

    @Test
    void getRelease_year() {
        assertEquals(1992,filmTest.getRelease_year(),"This test has failed");
    }

    @Test
    void setRelease_year() {
        filmTest.setRelease_year(1998);
        assertEquals(1998,filmTest.getRelease_year(),"This test has failed");
    }

    @Test
    void getLength() {
        assertEquals(82,filmTest.getLength(),"This test has failed");
    }

    @Test
    void setLength() {
        filmTest.setLength(100);
        assertEquals(100,filmTest.getLength(),"This test has failed");
    }

    @Test
    void getRating() {
        assertEquals("PG",filmTest.getRating(),"This test has failed");
    }

    @Test
    void setRating() {
        filmTest.setRating("U");
        assertEquals("U",filmTest.getRating(),"This test has failed");
    }

    @Test
    void getSpecial_features() {
        assertEquals("TestFeatures",filmTest.getSpecial_features(),"This test has failed");
    }

    @Test
    void setSpecial_features() {
        filmTest.setSpecial_features("NewFeatures");
        assertEquals("NewFeatures",filmTest.getSpecial_features(),"This test has failed");
    }

    @Test
    void getActorTest(){
        Set <Actor> testSet = new HashSet<>();
        testSet.add(new Actor("FirstName","SecondName"));
        filmTest.setActor(testSet);
        assertEquals(testSet,filmTest.getActor(),"This test has failed");

    }
}