package Part2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadMe {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ekrem\\OneDrive\\Masaüstü\\TechnoStudy\\Selenium\\SeleniumDependency\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.applitools.com/");

        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("ttechno@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("techno123.");

        WebElement submit = driver.findElement(By.id("log-in"));
        submit.click();

        WebElement text = driver.findElement(By.id("time"));
        System.out.println(text.getText());

        System.out.println(driver.getCurrentUrl());
        driver.quit();


    /*
        1) Navigate to https://demo.applitools.com/

        2) Enter the username as "ttechno@gmail.com"

        3) Enter the password as "techno123."

        4) Click on sign in button

        5) Get the following text and print it -->  Your nearest branch closes in: 30m 5s is displayed

        6) Print the URL
     */
    }
}
