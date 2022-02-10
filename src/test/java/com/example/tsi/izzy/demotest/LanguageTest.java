package com.example.tsi.izzy.demotest;

import com.example.tsi.izzy.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LanguageTest {

    @Test
    void getNameTest() {
        Language getNameTest = new Language("testName");
        assertEquals("testName",getNameTest.getName(),"This test has failed");
    }

    @Test
    void setNameTest() {
        Language getNameTest = new Language("testName");
        getNameTest.setName("testNameChange");
        assertEquals("testNameChange",getNameTest.getName(),"This test has failed");

    }

    @Test
    void getLanguage_idTest() {
        Language getNameTest = new Language("testName");
        assertEquals(0,getNameTest.getLanguage_id(),"This test has failed");
    }

    @Test
    void emptyConstructorTest() {
        Language language = new Language("testName");
        assertTrue(language instanceof Language,"This test has failed");
    }
}