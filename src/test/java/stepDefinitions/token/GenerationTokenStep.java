package stepDefinitions.token;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.GenerationTokenModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.IsTheResponseCode;
import tasks.GenerationTokenTasks;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GenerationTokenStep {

    // Environment variables
    private static final String URLSANDBOX = "https://sandbox.99minutos.com";
    private static final String URLUAT = "https://apiv3-uat-qndxoltwga-uc.a.run.app";

    // Class instances
    //GenerationTokenModel generationTokenModel = new GenerationTokenModel("24c7b8a1-fef0-4e24-9495-07f53fbdf6a4", "dSLJ0~4gPFh.0e4yFkzxLQtfSJ");
    Actor user;

    @Given("The user generate a token of authorization")
    public void the_user_generate_a_token_of_authorization() {
        user = Actor.named("The user")
                .whoCan(CallAnApi.at(URLSANDBOX));
    }
    @When("The user send request to endpoint")
    public void the_user_send_request_to_endpoint() {
        String generationToken = "{\n" +
                "    \"client_id\": \"24c7b8a1-fef0-4e24-9495-07f53fbdf6a4\",\n" +
                "    \"client_secret\": \"dSLJ0~4gPFh.0e4yFkzxLQtfSJ\"\n" +
                "}";

        user.attemptsTo(
                GenerationTokenTasks.withInfo(generationToken)
        );

    }
    @Then("The API should return the access token with status 200")
    public void the_API_should_return_the_access_token_with_status_200() {
        user.should(
                seeThat("Response Code", IsTheResponseCode.was(), equalTo(200))
        );

    }
}
