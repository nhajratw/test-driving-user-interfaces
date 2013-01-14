package com.chikli.codemash.tddui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.java.Before;

/**
 * Example of a WebDriver implementation that has an underlying instance that is
 * used for all scenarios and closed when the JVM exits. This saves time. To
 * prevent browser state from leaking between scenarios, cookies are deleted
 * before every scenario.
 * <p/>
 * As a bonus, screenshots are embedded into the report for each scenario. (This
 * only works if you're also using the HTML formatter).
 * <p/>
 * This class can be shared across step definitions via dependency injection.
 */
public class SharedDriver extends EventFiringWebDriver {
	private static final WebDriver REAL_DRIVER = new FirefoxDriver();

	static {
		REAL_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Runtime.getRuntime().addShutdownHook(new Thread() {
		// @Override
		// public void run() {
		// REAL_DRIVER.close();
		// }
		// });
	}

	public SharedDriver() {
		super(REAL_DRIVER);
	}

	@Before
	public void deleteAllCookies() {
		manage().deleteAllCookies();
	}

}