package com.stepDefination;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="newTours",glue= {"com.NewToursApplication"})

public class TestRunner {

}
