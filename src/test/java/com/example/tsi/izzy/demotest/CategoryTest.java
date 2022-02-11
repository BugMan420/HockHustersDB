package com.example.tsi.izzy.demotest;

import com.example.tsi.izzy.demo.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryTest {

    Category testCategory = new Category();

    @Test
    void getAndSetNameTest() {
        testCategory.setName("testCat");
        assertEquals("testCat",testCategory.getName(),"The test has failed");

    }

    @Test
    void getCategory_id() {
        assertEquals(0,testCategory.getCategory_id(),"This test has failed");
    }

    @Test
    void emptyConstructorTest() {
        assertTrue(testCategory instanceof Category,"This test has failed");
    }


}