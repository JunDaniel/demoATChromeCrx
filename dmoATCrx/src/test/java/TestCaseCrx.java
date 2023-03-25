import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class TestCaseCrx {
    public static final String PATH = "D:\\webdriver\\chromedriver.exe";
    public static final String DRIVER = "webdriver.chrome.driver";

    public static void main(String[] arg) {
        System.setProperty(DRIVER, PATH);
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("D:\\Code\\dmoATCrx\\src\\test\\resources\\extension_2_0_12_0.crx"));
        ChromeDriver driver = new ChromeDriver(options);
        //open chrome extension Google Translate
        driver.manage().window().maximize();
        driver.get("chrome-extension://aapbdbdomjkkjkaonfhkkikfgjllcleb/popup.html");

        WebDriverWait wait = new WebDriverWait(driver,20);
        //fill text tương lai to translate from vietnamese to english
        WebElement eleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text-input")));
        eleInput.sendKeys("tương lai");
        WebElement eleBtnTranslate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Translate')]")));
        eleBtnTranslate.click();

        //Verify display text Source
        WebElement eleTextSource = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'tương lai')]")));
        boolean isDisplayTextSource = eleTextSource.isDisplayed();
        if (isDisplayTextSource == true) {
            System.out.println("Display text source language: " + eleTextSource.getText());
        } else {
            System.out.println("Not display text source language!");
        }
        WebElement eleTextResultTrans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'future')]")));
        boolean isDisplayTextResultTrans = eleTextResultTrans.isDisplayed();
        if (isDisplayTextResultTrans == true) {
            System.out.println("Display text result translate: " + eleTextResultTrans.getText());
        } else {
            System.out.println("Not display text result translate!");
        }
        driver.quit();
    }
}
