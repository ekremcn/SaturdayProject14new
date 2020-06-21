package Part3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadMe {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ekrem\\OneDrive\\Masaüstü\\TechnoStudy\\Selenium\\SeleniumDependency\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.snapdeal.com/");

        driver.manage().window().maximize();

        WebElement searchItem = driver.findElement(By.id("inputValEnter"));
        searchItem.sendKeys("Teddy Bears");

        WebElement searchIcon = driver.findElement(By.className("searchTextSpan"));
        searchIcon.click();

        WebElement howManyResult = driver.findElement(By.className("nnn"));
        System.out.println(howManyResult.getText());

        System.out.println(driver.getCurrentUrl());


        WebElement logoFinder = driver.findElement(By.className("notIeLogoHeader"));
        logoFinder.click();

        System.out.println(driver.getCurrentUrl());
        driver.quit();

    }
    /*
        1) Navigate to https://www.snapdeal.com/

        2) Search for teddy bear click on search button

        3) Print the following text -->> We've got .... results for 'teddy bear'

        4) Print the URL

        5) Click on logo snepdeal logo

        6) Print the URL

     */


}
