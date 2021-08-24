package StepDefinitions;

import Utilities.BaseDriver;
import Utilities.ExcelUtility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {


    @Before//her senaryodan önce
    public void before(Scenario scenario)
    {

        System.out.println("Scenario is started");
        System.out.println("Scenario id=" + scenario.getId());
        System.out.println("Scenario name="+ scenario.getName());

    }



    @After//her senaryodan sonra
    public void after(Scenario scenario)
    {
        System.out.println("Scenario finished");
        System.out.println("Scenario result=" + scenario.getStatus() );
        System.out.println("Scenario is failed="+ scenario.isFailed());
        LocalDateTime date=null;
        DateTimeFormatter formatter=null;

        if (scenario.isFailed())//scenario hatali ise
            //ekran kaydetme bölümü
        {

            date = LocalDateTime.now();
            formatter = DateTimeFormatter.ofPattern("dd.MM.yy");

            TakesScreenshot screenshot = (TakesScreenshot) BaseDriver.getDriver();
            File file = screenshot.getScreenshotAs(OutputType.FILE);

            try {


                FileUtils.copyFile(file,new File("target/FailedScreenShots/"+
                        scenario.getId()+date.format(formatter)+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        ExcelUtility.writeExcel("src/test/java/ApachePOI/resources/ScenarioStatus.xlsx",scenario,BaseDriver.threadBrowserName.get(), date.format(formatter));
       BaseDriver.DriverQuit();

    }
}
