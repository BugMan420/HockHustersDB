package com.example.tsi.izzy.demotest;

import com.example.tsi.izzy.demo.Actor;
import com.example.tsi.izzy.demo.Film;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ActorTest {

    Actor actorTest = new Actor("FirstName","LastName");

    @Test
    void getAndSetNameTest() {
        actorTest.setFirst_name("FirstChange");
        actorTest.setLast_name("LastChange");
        assertEquals("FirstChange",actorTest.getFirst_name(),"The first name is not correct");
        assertEquals("LastChange",actorTest.getLast_name(),"The last name is not correct");
    }

    @Test
    void Actor_id() {
        actorTest.setActor_id(1);
        assertEquals(1,actorTest.getActor_id(),"This test has failed");
    }

    @Test
    void getFilmTest(){
        Set<Film> testSet = new HashSet<>();
        testSet.add(new Film());
        actorTest.setFilms(testSet);
        assertEquals(testSet,actorTest.getFilms(),"This test has failed");

    }

    @Test
    void emptyConstructorTest() {
        Actor actor = new Actor();
        assertTrue(actor instanceof Actor,"This test has failed");
    }

}