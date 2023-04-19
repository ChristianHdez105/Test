package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateTokenTasks implements Task {
    private final String tokenInformation;

    public CreateTokenTasks(String tokenInformation) {
        this.tokenInformation = tokenInformation;
    }

    public static Performable withInfo(String tokenInformation) {
        return instrumented(CreateTokenTasks.class, tokenInformation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/v3/oauth/token").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("Content-Type","application/json")
                                .body(tokenInformation)
                )
        );
    }
}
