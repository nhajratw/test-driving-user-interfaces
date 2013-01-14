package com.chikli.codemash.tddui;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaconTrackerSteps {

	private final Homepage homepage;

	public BaconTrackerSteps(final Homepage homepage) {
		this.homepage = homepage;
	}

	@Given("^I am on the homepage$")
	public void I_am_on_the_homepage() throws Throwable {
		homepage.go();
	}

	@Then("^I should see the header \"([^\"]*)\"$")
	public void I_should_see_the_header(final String header) throws Throwable {
		assertThat(homepage.header(), is(header));
	}

	@Then("^the logo should appear$")
	public void the_logo_should_appear() throws Throwable {
		assertThat(homepage.logo_exists(), is(true));
	}

	@When("^I add \"([^\"]*)\" with an email of \"([^\"]*)\"$")
	public void I_add_with_an_email_of(final String name, final String email) throws Throwable {
		homepage.addPerson(name, email);
	}

	@Then("^a confirmation should appear for \"([^\"]*)\"$")
	public void a_confirmation_should_appear_for(final String name) throws Throwable {
		assertThat(homepage.confirmationFor(name), is(true));
	}

	@Then("^the person \"([^\"]*)\" should show up in the list$")
	public void the_person_should_show_up_in_the_list(final String name) {
		assertThat(homepage.peopleListContains(name), is(true));
	}

}
