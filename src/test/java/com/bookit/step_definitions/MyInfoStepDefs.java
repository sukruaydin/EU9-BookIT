package com.bookit.step_definitions;


import com.bookit.pages.SelfPage;
import com.bookit.pages.SignInPage;
import com.bookit.utilities.*;
import cucumber.runtime.Env;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;


public class MyInfoStepDefs {

	@Given("user logs in using {string} {string}")
	public void user_logs_in_using(String email, String password) {
	    Driver.get().get(ConfigurationReader.get("url_qa2"));
	    Driver.get().manage().window().maximize();
		Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    SignInPage signInPage = new SignInPage();
	    signInPage.email.sendKeys(email);
	    signInPage.password.sendKeys(password);
		BrowserUtils.waitFor(1);
	    signInPage.signInButton.click();
	}

	@When("user is on the my self page")
	public void user_is_on_the_my_self_page() {
	    SelfPage selfPage = new SelfPage();
	    selfPage.goToSelf();
	}


	@Given("I get env properties")
	public void iGetEnvProperties() {

		System.out.println(Environment.URL);
		System.out.println(Environment.BASE_URL);
		System.out.println(Environment.DB_USERNAME);
		System.out.println(Environment.DB_PASSWORD);
		System.out.println(Environment.DB_URL);

		System.out.println(Environment.TEACHER_EMAIL);
		System.out.println(Environment.TEACHER_PASSWORD);

		BookItApiUtil.getTokenByRole("teacher");
		BookItApiUtil.getTokenByRole("student-member");
		BookItApiUtil.getTokenByRole("student-leader");


	}
}
