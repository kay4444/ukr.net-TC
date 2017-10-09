package MainSettings;

import Pages.StartPage;
import TrackReporting.CaptureScreenShotOnFailureListener;
import TrackReporting.LoggingEventListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by serhii.kaihorodov on 1/4/2016.
 */
@Listeners(CaptureScreenShotOnFailureListener.class)
//@Listeners()
public class Settings {
    protected static WebDriver driver;
    protected String baseURL = "https://www.ukr.net";
    private static final WebDriverEventListener eventListener = new LoggingEventListener();
    protected StartPage mainPage;
    private Map<String, ThreadLocal> drivers = new HashMap<String, ThreadLocal>();


    protected static String env = "chrome";

    @BeforeMethod
    public void setUp() {
        if(env == "chrome"){
            String path_to_chromedriver = System.getProperty("user.dir").replaceAll("KayTC", "");
            System.setProperty("webdriver.chrome.driver", path_to_chromedriver + "chromedriver.exe");
            driver = new EventFiringWebDriver(new ChromeDriver()).register(eventListener);
        }
        else if(env == "firefox"){
            driver = new EventFiringWebDriver(new FirefoxDriver()).register(eventListener);
        }
        getDriver().get(baseURL);
        mainPage = new StartPage();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkPageIsReady() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page Is loaded.");
            return;
        }
        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    public void wait_for_page_header_is_available(int sec, String name) {
        for (int i = 0; i < sec; i++) {
            if (getDriver().getTitle() != name) {
                sleep(1);
            } else {
                break;
            }
        }
    }
}
















//public class Settings {
//    private WebDriver driver;
//    protected String baseURL = "https://www.ukr.net";
//    private static final WebDriverEventListener eventListener = new LoggingEventListener();
//    protected StartPage mainPage;
//    private Map<String, ThreadLocal> drivers = new HashMap<String, ThreadLocal>();
//
//
//
//
//
//    @BeforeMethod
//    public void setUp()
//    {
//        Map<String, ThreadLocal> drivers = new HashMap<String, ThreadLocal>();
//        System.setProperty("webdriver.chrome.driver", "D:\\Programming\\Java Automation\\ukr.net_test_cases-master\\chromedriver.exe");
//
//
//
//        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
//        ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();
//        threadedDriver.set(getDriver());
//
//        drivers.put(testName, threadedDriver); //so it can be saved in memory
//        driver = (WebDriver) drivers.get(testName).get(); //this is how you get the object for regular use
////        driver = new EventFiringWebDriver(new FirefoxDriver()).register(eventListener);
//        driver = new EventFiringWebDriver(new ChromeDriver()).register(eventListener);
//
//        driver.get(baseURL);
//        mainPage = new StartPage();
////        driver.manage().window().maximize();
//    }
//
//    @AfterMethod
//    public void tearDown()
//    {
//        driver.close();
//        driver.quit();
//    }
//
//    public WebDriver getDriver()
//    {
//        return driver;
//    }
//
//    public static void waitInSeconds (int seconds)
//    {
//        try {
//            Thread.sleep(1000*seconds);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}