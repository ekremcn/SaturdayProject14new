import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Account {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ekrem\\OneDrive\\Masaüstü\\TechnoStudy\\Selenium\\SeleniumDependency\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().window().maximize();

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='session_email']"));
        emailInput.sendKeys("testNG@hotmail.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='session_password']"));
        passwordInput.sendKeys("E125112.c");

        WebElement signIn = driver.findElement(By.cssSelector("input[type='submit']"));
        signIn.click();

        WebElement adresses = driver.findElement(By.xpath("//a[text()='Addresses']"));
        adresses.click();

        Thread.sleep(1000);
        WebElement newAddress = driver.findElement(By.xpath("//a[@href='/addresses/new']"));
        newAddress.click();

        Thread.sleep(1000);
        driver.findElement(By.id("address_first_name")).sendKeys("Fernando");
        driver.findElement(By.id("address_last_name")).sendKeys("Torres");
        driver.findElement(By.id("address_street_address")).sendKeys("Anfield Rd");
        driver.findElement(By.id("address_secondary_address")).sendKeys("Anfield");
        driver.findElement(By.cssSelector("input[id='address_city']")).sendKeys("Liverpool");

        WebElement stateDropdown = driver.findElement(By.cssSelector("select[id='address_state']"));
        Select states = new Select(stateDropdown);

        List<WebElement> stateList = states.getOptions();
        Random rnd = new Random();
        int randomNum = rnd.nextInt(stateList.size());
        states.selectByIndex(randomNum);

        driver.findElement(By.id("address_zip_code")).sendKeys("L4 0TH");
        driver.findElement(By.xpath("//label[text()='United States']")).click();
        driver.findElement(By.name("address[birthday]")).sendKeys("20/03/1984");
        driver.findElement(By.id("address_age")).sendKeys("36");
        driver.findElement(By.name("address[website]")).sendKeys("https://www.google.com/");
        driver.findElement(By.id("address_phone")).sendKeys("8625747878");
        driver.findElement(By.xpath("//label[text()='Climbing']")).click();
        driver.findElement(By.xpath("//label[text()='Dancing']")).click();
        driver.findElement(By.name("address[note]")).sendKeys("Never Back Down");
        driver.findElement(By.cssSelector("input[data-disable-with='Create Address']")).click();

        //verifying first Name
        try {
            WebElement nameCheck = driver.findElement(By.cssSelector("p>span[data-test='first_name']"));
            Assert.assertEquals("Fernando", nameCheck.getText());
        } catch (NoSuchElementException e) {
            System.out.println("There is no name like as Fernando");
        }

        //verifying last Name
        try {
            WebElement lastnameCheck = driver.findElement(By.cssSelector("p>span[data-test='last_name']"));
            Assert.assertEquals("Torres", lastnameCheck.getText());
        } catch (NoSuchElementException e) {
            System.out.println("There is no last_name like as Torres");
        }

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Edit')]")).click();

        Thread.sleep(1000);
        WebElement editFirstName = driver.findElement(By.xpath("//input[@id='address_first_name']"));
        editFirstName.clear();
        editFirstName.sendKeys("Peter");

        WebElement editLastname = driver.findElement(By.xpath("//input[@id='address_last_name']"));
        editLastname.clear();
        editLastname.sendKeys("Crouch");

        driver.findElement(By.cssSelector("div>input[value='Update Address']")).click();

        try {
            WebElement editAgainFirstName = driver.findElement(By.cssSelector("span[data-test='first_name']"));
            Assert.assertEquals("Peter", editAgainFirstName.getText());
        } catch (NoSuchElementException e) {
            System.out.println("There is no name like as Peter");
        }

        try {
            WebElement editAgainLastName = driver.findElement(By.cssSelector("span[data-test='last_name']"));
            Assert.assertEquals("Crouch", editAgainLastName.getText());
        } catch (NoSuchElementException e) {
            System.out.println("There is no lastname like as Crouch");
        }

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Destroy")).click();

        driver.switchTo().alert().accept();

    }

}
