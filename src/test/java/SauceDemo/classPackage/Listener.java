package SauceDemo.classPackage;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class Listener implements ITestListener {

    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
    }

//    @After
//    public void tearDown(Scenario scenario) {
//
//        try {
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            if (scenario.isFailed()) {
//                scenario.log("this is my failure message");
//                TakesScreenshot ts = (TakesScreenshot) driver;
//                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "image/png", screenshotName);
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//        driver.close();
//    }

//    public static WebDriver getDriver(){
//        return driver;
//    }
//    @Override
//    public void onTestFailure(ITestResult result){
//        saveScreenshot(getDriver());
//        saveTextLog(result.getMethod().getConstructorOrMethod().getName());
//    }
//
//
//    @Attachment(value = "Page Screenshot", type = "image/png")
//    public byte[] saveScreenshot(WebDriver driver){
//        return((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//    }
//    @Attachment(value = "testcases",type = "text/plain")
//    public static String saveTextLog(String message){
//        return message;
//    }




//    @Override
//    public void onTestFailure(ITestResult result) {
//
//        Allure.addAttachment("screenShot", new ByteArrayInputStream(((TakesScreenshot)result.getTestContext().getAttribute("WebDriver")).getScreenshotAs(OutputType.BYTES)));
//
//        Object webDriverAttribute = result.getTestContext().getAttribute("WebDriver");
//        captureScreenshot((WebDriver) webDriverAttribute);
//
//    }
//
//    private void captureScreenshot(WebDriver webDriverAttribute) {
//    }

//Allure.addAttachment(nameTest, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));


//@After
//    public void onTestFailure(ITestResult result) {
//        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
//        System.out.println(result.getMethod().getMethodName() + " failed!");
//
//        ITestContext context = result.getTestContext();
//        WebDriver driver = (WebDriver) context.getAttribute("driver");
//
//        // attach screenshots to report
//        saveFailureScreenShot(driver);
//    }
//
//
//    @Attachment
//    public byte[] saveFailureScreenShot(WebDriver driver) {
//        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//    }
}
