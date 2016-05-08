package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CourseSearch;

/**
 * Created by Kate on 07/05/2016.
 */
public class searchCourses {
    public CourseSearch CS = new CourseSearch();
/*
    @Before
    public void initialiseDriver() {
        CS.initialise();
    }

    @After
    public void closeBrowser() {
        CS.close();
    }
*/
    @Given("^I have navigated to the Courses search tab$")
    public void I_have_navigated_to_the_Courses_search_tab() throws Throwable {
        System.out.println("");
        System.out.println("I_have_navigated_to_the_Courses_search_tab");
        CS.reset();
    }

    @When("^I enter the search terms$")
    public void I_enter_the_search_terms() throws Throwable {
        System.out.println("");
        System.out.println("I_enter_the_search_terms");
        CS.populate("begin", "r", "r");
    }

    @When("^click on the course search button$")
    public void click_on_the_course_search_button() throws Throwable {
        System.out.println("");
        System.out.println("click_on_the_course_search_button");
        CS.search();
    }

    @Then("^I see a paginated list of matching course results$")
    public void I_see_a_paginated_list_of_matching_course_results() throws Throwable {
        System.out.println("");
        System.out.println("I_see_a_paginated_list_of_matching_course_results");
        CS.verifyResults();
    }

    @Then("^can drill down to course detail level$")
    public void can_drill_down_to_course_detail_level() throws Throwable {
        System.out.println("");
        System.out.println("can_drill_down_to_course_detail_level");
    }
}
