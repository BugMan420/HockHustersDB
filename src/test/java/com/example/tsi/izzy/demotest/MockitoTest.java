package com.example.tsi.izzy.demotest;

import com.example.tsi.izzy.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    private SakilaDatabaseApplication sakilaDatabaseApplication;
    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void Setup() {
        sakilaDatabaseApplication = new SakilaDatabaseApplication(
                languageRepository,
                actorRepository,
                filmRepository,
                categoryRepository);
    }

    @Test
    public void testAddLanguage() {
        Language saveLanguage = new Language("testLanguage"); //Post Request for mockDB
        String expected = "save"; //response
        String actual = sakilaDatabaseApplication.addLanguage(saveLanguage.getName());
        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class); //holds data temporarily
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "The data has not been entered into the mock DB");
    }

    @Test
    public void testAddActor() {
        Actor saveActor = new Actor("testName","testSurname");
        String expected = "save"; //response
        String actual = sakilaDatabaseApplication.addActor(saveActor.getFirst_name(), saveActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class); //holds data temporarily
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "The data has not been entered into the mock DB");
    }

   @Test
   public void testGetLanguage(){
       {
           Language language1 = new Language ("TestLOne");
           Language language2 = new Language ("TestLTwo");
           Language language3 = new Language ("TestLThree");
           List<Language> languageList = new ArrayList<>();
           languageList.add(language1);
           languageList.add(language2);
           languageList.add(language3);
           when(sakilaDatabaseApplication.getAllLanguages()).thenReturn(languageList);
           Assertions.assertEquals(languageList,sakilaDatabaseApplication.getAllLanguages(),"This test has not worked");
   }
    }

    @Test
    public void testGetActors(){
        {
            Actor actor1 = new Actor("Bool","Leean");
            Actor actor2 = new Actor ("Test","Tea");
            List<Actor> actorList = new ArrayList<>();
            actorList.add(actor1);
            actorList.add(actor2);
            when(sakilaDatabaseApplication.getAllActor()).thenReturn(actorList);
            Assertions.assertEquals(actorList,sakilaDatabaseApplication.getAllActor(),"This test has not worked");
        }
    }


    /*@Test
    public void testUpdateActor() {
        Actor updateActor = new Actor(1,"testName","testLastName");
        Actor expectedActor = new Actor("ChangeName","ChangeSurname");
        updateActor.setFirst_name("ChangeName");
        updateActor.setLast_name("ChangeSurname");
        String actual = sakilaDatabaseApplication.updateActor(1,
                updateActor.getFirst_name(), updateActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expectedActor,updateActor,"The actor hasn't been updated");
    }*/
}