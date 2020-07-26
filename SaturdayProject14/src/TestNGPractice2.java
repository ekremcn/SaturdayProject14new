import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.TimeBombSkipException;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class TestNGPractice2 extends BaseDriver {
    @Test
    public void test2() throws InterruptedException {
        ProjectObjectModel projectObjectModel = new ProjectObjectModel(driver);

        projectObjectModel.dressButton.click();

        List<WebElement> dressList = projectObjectModel.productList;
        int r = RandomNumberGenerator(dressList.size());
        js.executeScript("scroll(0,1000)");
        builder.moveToElement(dressList.get(r)).perform();

        wait.until(ExpectedConditions.elementToBeClickable(projectObjectModel.wishListButton.get(r)));

        projectObjectModel.wishListButton.get(r).click();

        wait.until(ExpectedConditions.elementToBeClickable(projectObjectModel.carpiButton));
        projectObjectModel.carpiButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(projectObjectModel.signInButton));
        projectObjectModel.signInButton.click();

        projectObjectModel.wishLists.click();

        projectObjectModel.viewButton.click();

        //verification
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div[class='wlp_bought']>ul>li"), 0));

        projectObjectModel.deleteItemButton.click();

        //Verify item is not in the wishlist anymore
        wait.until(ExpectedConditions.invisibilityOf(projectObjectModel.deleteItemButton));

        projectObjectModel.deleteWishList.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();


    }

    public int RandomNumberGenerator(int max) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(max - 1) + 1;
        return randomNumber;
    }

}
/*num
NOTE: All TestNG practices should be in the same project and in the different class

Navigate to:  http://automationpractice.com/index.php
Click on sign in button
Enter the Email Address and Password (Create your own account from left side)
Click on sign in button

Click on dresses
Click on any item
Click on the add to wishlist

Click on the user name on the top right  (Next to sign out button )

Click on "My WISHLIST" button

Verify Item is in the wishlist

Click on X button under the Item picture

Verify item is not in the wishlist anymore

Click on the X button under the Delete column

Click on the OK button
 */