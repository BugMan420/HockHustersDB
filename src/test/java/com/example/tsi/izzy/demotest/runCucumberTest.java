package com.example.tsi.izzy.demotest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"Pretty"},features="src/test/resources/Cucumber", glue = "com.example.tsi.izzy.demotest")
public class runCucumberTest {

}
