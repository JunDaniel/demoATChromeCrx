import org.hamcrest.MatcherAssert;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class TestSuiteCrx {
    public static final String PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";
    public static final String DRIVER = "webdriver.chrome.driver";
    public static final String PATH_FILE_CRX = System.getProperty("user.dir") + "\\src\\test\\resources\\extension_2_0_12_0.crx";
    public static final String URL_EXTENSION_GOOGLE_TRANSLATE = "chrome-extension://aapbdbdomjkkjkaonfhkkikfgjllcleb/popup.html";
    WebDriver getDriver;
    public static WebDriverWait webWait = null;

    @Before
    public void setUp(){
        System.setProperty(DRIVER, PATH);
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(PATH_FILE_CRX));
        ChromeDriver driver = new ChromeDriver(options);
        getDriver = driver;
        WebDriverWait wait = new WebDriverWait(driver,20);
        webWait = wait;
        //open chrome extension Google Translate
        driver.manage().window().maximize();
        driver.get(URL_EXTENSION_GOOGLE_TRANSLATE);
    }

    @Test
    public void TC01_Translate_Vietnamese_To_English() {
        //fill text tương lai to Google translate Extension to translate from vietnamese to english
        WebElement eleInput = webWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text-input")));
        eleInput.sendKeys("tương lai");
        //click button Translate
        WebElement eleBtnTranslate = webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Translate')]")));
        eleBtnTranslate.click();

        //Verify that display text Source
        WebElement eleTextSource = webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'tương lai')]")));
        boolean isDisplayTextSource = eleTextSource.isDisplayed();
        if (isDisplayTextSource == true) {
            Assert.assertTrue(isDisplayTextSource);
            System.out.println("Display text source language: " + eleTextSource.getText());
        } else {
            Assert.assertTrue(isDisplayTextSource);
            System.out.println("Not display text source language!");
        }

        //Verify that display text Result translate
        WebElement eleTextResultTrans = webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'future')]")));
        boolean isDisplayTextResultTrans = eleTextResultTrans.isDisplayed();
        if (isDisplayTextResultTrans == true) {
            Assert.assertTrue(isDisplayTextResultTrans);
            System.out.println("Display text result translate: " + eleTextResultTrans.getText());
        } else {
            Assert.assertTrue(isDisplayTextResultTrans);
            System.out.println("Not display text result translate!");
        }
    }

    @After
    public void closeBrowser () {
        //close Chrome Browser
        getDriver.quit();
    }
}
