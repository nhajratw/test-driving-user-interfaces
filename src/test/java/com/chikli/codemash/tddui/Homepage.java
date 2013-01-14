package com.chikli.codemash.tddui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	private final SharedDriver driver;

	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(id = "logo")
	private WebElement logo;

	@FindBy(className = "alert-success")
	private WebElement confirmationMessage;

	@FindBy(id = "person-name")
	private WebElement personName;

	@FindBy(id = "person-email")
	private WebElement personEmail;

	@FindBy(id = "save-person")
	private WebElement saveButton;

	@FindBy(id = "people")
	private WebElement people;

	public Homepage(final SharedDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void go() {
		driver.get("http://loki.local:8080");
	}

	public String header() {
		return header.getText();
	}

	public boolean logo_exists() {
		return logo.isDisplayed();
	}

	public void addPerson(final String name, final String email) {
		personName.sendKeys(name);
		personEmail.sendKeys(email);
		saveButton.click();
	}

	public boolean confirmationFor(final String name) {
		return confirmationMessage.getText().equals("Added " + name);
	}

	public boolean peopleListContains(final String name) {
		for (final WebElement personCell : people.findElements(By.tagName("td"))) {
			if (personCell.getText().contains(name)) {
				return true;
			}
		}

		return false;
	}

}
