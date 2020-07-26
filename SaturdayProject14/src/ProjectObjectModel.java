import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProjectObjectModel {

    public ProjectObjectModel(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    public WebElement firstname;

    @FindBy(id = "lastname")
    public WebElement lastname;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "address2")
    public WebElement address2;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement id_state;

    @FindBy(id = "postcode")
    public WebElement postcode;

    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "alias")
    public WebElement alias;

    @FindBy(id = "submitAddress")
    public WebElement saveButton;

    @FindBy(xpath = "(//h3[@class='page-subheading'])[2]")
    public WebElement adressUpdate;

    @FindBy(xpath = "(//a[@title='Update'])[2]")
    public WebElement updateButton2;

    @FindBy(xpath = "(//span[@class='address_name'])[3]")
    public WebElement newFirstName;

    @FindBy(xpath = "(//span[@class='address_name'])[4]")
    public WebElement newLastName;

    @FindBy(xpath = "(//a[@title='Delete'])[2]")
    public WebElement deleteButton2nd;


    //2nd Practice
    @FindBy(xpath = "(//a[@title='Dresses'])[2]")
    public WebElement dressButton;

    @FindBy(css = "div[class='product-container']")
    public List<WebElement> productList;

    @FindBy(css = ".wishlist>a")
    public List<WebElement> wishListButton;

    @FindBy(css = "a[class='fancybox-item fancybox-close']")
    public WebElement carpiButton;

    @FindBy(xpath = "(//div[@class='header_user_info'])[1]")
    public WebElement signInButton;

    @FindBy(css = "i[class='icon-heart']")
    public WebElement wishLists;

    @FindBy(xpath = "//a[contains(text(),'View')]")
    public WebElement viewButton;

    @FindBy(css = "a[title='Delete']")
    public WebElement deleteItemButton;

    @FindBy(css = ".row")
    public List<WebElement> wishListDresses;

    @FindBy(css = ".row .lnkdel")
    public WebElement removefromWishList;

    @FindBy(css = "tr[id*='wishlist']>td:last-child>a")
    public WebElement deleteWishList;

}
