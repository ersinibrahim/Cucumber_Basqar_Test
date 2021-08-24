package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 //* plugin kısmı ise basit rapor oluşturan kısım
      //  * "html:target/cucumber-report" : target klasörünün altında cucumber-report un
     //   * altında basit bir rapor oluşturacak.
     //   *
    //    * "json:target/cucumber.json" : aynı raporu JSON formatında oluşturacak.
     //   *

@CucumberOptions(

        tags = {"@SmokeTest"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {
                "html:target/cucumber-report",
                "json:target/cucumber.json",

        }


)




public class _05_TestRunnerRegressionWithPlugin extends AbstractTestNGCucumberTests {
}
