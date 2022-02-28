package com.example.tsi.izzy.demotest;

import com.example.tsi.izzy.demo.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class menuCucumberStepsDef {
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

                languageRepository = mock(LanguageRepository.class);
                actorRepository = mock(ActorRepository.class);
                filmRepository = mock(FilmRepository.class);
                categoryRepository= mock(CategoryRepository.class);

        sakilaDatabaseApplication = new SakilaDatabaseApplication(
                languageRepository,actorRepository,filmRepository,
                categoryRepository);
    }

Actor saveActor;
    @Given("I want to add a new actor")
    public void i_want_to_add_a_new_actor() {
        Setup();
        // Write code here that turns the phrase above into concrete actions
        saveActor = new Actor("testName","testSurname");
    }

    String actual;
    @When("The user adds a new actor")
    public void the_user_adds_a_new_actor() {
        // Write code here that turns the phrase above into concrete actions
        actual = sakilaDatabaseApplication.addActor(saveActor.getFirst_name(), saveActor.getLast_name());
    }
    @Then("The actor is saved to the database")
    public void the_actor_is_saved_to_the_database() {
        // Write code here that turns the phrase above into concrete actions
        String expected = "save";

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class); //holds data temporarily
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "The data has not been entered into the mock DB");

    }
}
