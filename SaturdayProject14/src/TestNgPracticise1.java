import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TestNgPracticise1 extends BaseDriver {

    @Test
    public void createAndDeleteAdresse() {
        ProjectObjectModel projectObjectModel = new ProjectObjectModel(driver);

        WebElement myAdress = driver.findElement(By.className("icon-building"));
        myAdress.click();

        WebElement addNewAdress = driver.findElement(By.xpath("//span[text()='Add a new address']"));
        addNewAdress.click();

        projectObjectModel.company.sendKeys("canlar");

        projectObjectModel.address1.sendKeys("ludwigsburger strasse");

        projectObjectModel.address2.sendKeys("canlar apt. ");

        projectObjectModel.city.sendKeys("möglingen");

        Select state = new Select(projectObjectModel.id_state);
        state.selectByIndex(new Random().nextInt(54));

        projectObjectModel.postcode.sendKeys("70816");

        projectObjectModel.phone.sendKeys("015787985125");

        String adressName = "adressnew";
        projectObjectModel.alias.clear();
        projectObjectModel.alias.sendKeys(adressName);

        projectObjectModel.saveButton.click();

        Assert.assertTrue(adressName.equalsIgnoreCase(projectObjectModel.adressUpdate.getText()));

        projectObjectModel.updateButton2.click();

        projectObjectModel.firstname.clear();
        projectObjectModel.firstname.sendKeys("ilhan");

        projectObjectModel.lastname.clear();
        projectObjectModel.lastname.sendKeys("ercan");

        projectObjectModel.saveButton.click();

        String firstName = "ilhan";
        Assert.assertTrue(firstName.equalsIgnoreCase(projectObjectModel.newFirstName.getText()));

        String lastName = "ercan";
        Assert.assertTrue(lastName.equalsIgnoreCase(projectObjectModel.newLastName.getText()));

        projectObjectModel.deleteButton2nd.click();

        driver.switchTo().alert().accept();

        try {
            wait.until(ExpectedConditions.visibilityOf(projectObjectModel.adressUpdate));
        } catch (Exception e) {
            System.out.println("Verify address is removed from the website");
        }
    }

}
/*
NOTE: All TestNG practices should be in the same project and in the different class

Everybody in the team should create their own account.

Everybody in the team should upload the project individually.

And everyone in the team should push the code to github as well.

One member in the team should send the project to sena or ali but everyone push the code to github.

After finishing the project create testNG.xml file and in this file run the TestNG Practices 1
and TestNG Practices 2 run the project as parallel and in the chrome and in the firefox.
Use the Thread.sleep as less as you can. Use a explicit wait.

DO NOT DO THIS PROJECT IN THE MAIN METHOD PROJECT SHOULD BE IN THE
 TESTNG.

Use a page object model concept. Create a baseDriver class and login functionality should
be done in this class.

Use a page object model concept while working on the project.


 Navigate to:  http://automationpractice.com/index.php

Click on sign in button

Click on the my addresses

Click on the add a new address

Enter all the fields (Choose random items from the dropdown)

Click on save button

Verify your address is displayed in the website

Click on the update button

Change the first name and last name

Click on the save button

Verify first name and last name is updated

Click on the delete button

Click on the okay

Verify address is removed from the website
 */