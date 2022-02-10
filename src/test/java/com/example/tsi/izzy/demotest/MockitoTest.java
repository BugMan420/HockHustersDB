package com.example.tsi.izzy.demotest;

import com.example.tsi.izzy.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;



import static org.mockito.Mockito.verify;

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
    void Setup(){
        sakilaDatabaseApplication = new SakilaDatabaseApplication(
                languageRepository,
                actorRepository,
                filmRepository,
                categoryRepository);
    }

    @Test
    public void testAddLanguage(){
        Language saveLanguage = new Language ("testLanguage"); //Post Request for mockDB
        String expected = "save"; //response
        String actual  = sakilaDatabaseApplication.addLanguage(saveLanguage.getName());
        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class); //holds data temporarily
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"The data has not been entered into the mock DB");
    }

}
