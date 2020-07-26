package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseDriver {

    protected WebDriver driver;
    protected Actions builder;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;


    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    protected void setup(@Optional("chrome") String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ekrem\\OneDrive\\Masaüstü\\TechnoStudy\\Selenium\\SeleniumDependency\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver" ,"C:\\Users\\ekrem\\OneDrive\\Masaüstü\\TechnoStudy\\Selenium\\SeleniumDependency\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        builder = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        WebElement login = driver.findElement(By.className("login"));
        login.click();

        By email = By.id("email");
        wait.until(ExpectedConditions.elementToBeClickable(email));
        WebElement emailAdresse = driver.findElement(email);
        emailAdresse.sendKeys("ekrem20092013@gmail.com");

        WebElement password= driver.findElement(By.id("passwd"));
        password.sendKeys("3229e");

        WebElement signIn=driver.findElement(By.cssSelector("span>i[class='icon-lock left']"));
        signIn.click();

    }

    @AfterClass(alwaysRun = true)
   protected void close(){
//        driver.quit();
   }
}
