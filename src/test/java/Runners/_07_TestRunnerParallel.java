package Runners;


import Utilities.BaseDriver;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(

        tags = {"@SmokeTest"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportRegression.html"
                // oluşturalacak raporun yeri ve adı veriliyor.
                //listener test calisirken testi takip edip dinleyecek raporda aktaracak bu sonuclari

        }
)
public class _07_TestRunnerParallel extends AbstractTestNGCucumberTests {

@BeforeClass
@Parameters("browser")
public void beforeClass(String browser){

    BaseDriver.threadBrowserName.set(browser);
}


    @AfterClass
    public static void afterClass()
    {

        Reporter.loadXMLConfig("src/test/java/XmlFiles/ExtendReportSet.xml");                                //Reporter cucumber.listener dan al
        Reporter.setSystemInfo("User Name","Ersin Übung");
        Reporter.setSystemInfo("Application Name","Basqar");
        Reporter.setSystemInfo("Operating System Info",System.getProperty("os.name").toString());
        Reporter.setSystemInfo("Department","QAr");
        Reporter.setSystemInfo("Ek Satir","Aciklamasi");


        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");



    }



}
