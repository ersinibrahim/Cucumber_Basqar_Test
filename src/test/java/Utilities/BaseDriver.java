package Utilities;

import Pages.Parent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {

    //her thread e özel driver olacak ve static oldugu icin o thread deki bütün classlar ayni DRIVER i kullanmis olacak
    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();//WebDriver 1/2
    public static ThreadLocal<String> threadBrowserName=new ThreadLocal<>();


    public static WebDriver getDriver() {

        if (threadBrowserName.get()==null){
            threadBrowserName.set("chrome");
        }

        if (threadDriver.get() == null) {//Bu hatta driver var mi?
            //yoksa hangi tür isteniyorsa o setleniyor.
            switch (threadBrowserName.get())
            {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver());
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                    break;
            }


        }
        return threadDriver.get();
    }

    public static void DriverQuit()
    {

        Parent.delay(5);

        if (threadDriver.get() !=null)
        {
            threadDriver.get().quit();
            WebDriver driver=threadDriver.get();
            driver=null;
            threadDriver.set(driver);
        }




    }
}
