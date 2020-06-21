package Part1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadMe {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ekrem\\OneDrive\\Masaüstü\\TechnoStudy\\Selenium\\SeleniumDependency\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://demoqa.com/text-box");

        driver.manage().window().maximize();

        WebElement searchItem = driver.findElement(By.id("userName"));
        searchItem.sendKeys("Automation");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("Testing@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Testing Current Address part 1");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Testing Current Address part 2");


        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("scroll(0,400);");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement name = driver.findElement(By.className("mb-1"));
        System.out.println(name.getText());

        WebElement email = driver.findElement(By.id("email"));
        System.out.println(email.getText());
        driver.quit();






    /*
        1) Navigate to  http://demoqa.com/text-box

        2) Enter full name as "Automation"

        3) Enter Email as "Testing@gmail.com"

        4) Enter Current Address 1 as "Testing Current Address part 1"

        5) Enter Current Address 2 "Testing Current Address part 2"

        6) Click on submit button

        7) Print the name

        8) Print Email is containing the "Testing"

     */
    }
}
