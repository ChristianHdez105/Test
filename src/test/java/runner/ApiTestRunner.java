package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/token/token.feature",
        plugin = {
                "pretty"
        },
        tags = "@ScenarioToken",
        glue = "stepDefinitions/token",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ApiTestRunner {

}
