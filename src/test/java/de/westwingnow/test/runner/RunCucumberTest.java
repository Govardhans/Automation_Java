package de.westwingnow.test.runner;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import de.westwingnow.config.StaticConfig;
import de.westwingnow.config.TestConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "de.westwingnow.step.def",
        dryRun = false,
        publish = true,
        monochrome = true,
        stepNotifications = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"json:target/json-cucumber-reports/cukejson.json", "html:target/cucumber-report/1.html", "pretty"}


)
public class RunCucumberTest {

    /**
     * Selenide rule for taking screenshots
     */
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);

    /**
     * configuration settings before test cases starts execution <br>
     * This can be done through config.yml TODO
     */
    @BeforeClass
    public static void setUp() {
        new TestConfig();
        Configuration.baseUrl = TestConfig.URL;
        Configuration.browser = StaticConfig.BROWSER;
        Configuration.browserSize = "1920x1080";
        Configuration.fastSetValue = true;
        Configuration.timeout = StaticConfig.WAIT_IN_MILLIS;
        Configuration.headless = StaticConfig.HEADLESS;
    }
}