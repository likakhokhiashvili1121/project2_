import com.codeborne.selenide.WebDriverRunner;
import db.DBconnection;
import db.DataBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class FinalSwoopTest {

    WebDriver driver;
    MainSteps mainSteps = new MainSteps();
    RestSteps relaxSteps = new RestSteps();
    SushiSteps sushiSteps = new SushiSteps();
    CategoriesSteps categoriesSteps = new CategoriesSteps();
    SushiShareSteps mainSushiSteps = new SushiShareSteps();
    DataBase dataBase = new DataBase();
    RegistrationSteps registrationSteps = new RegistrationSteps();
    DBconnection dBconnection = new DBconnection();

    @BeforeMethod(alwaysRun = true)
    @Story("Opening URL for Tests")
    @Description("Maximize the browser window")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        open("https://www.swoop.ge/");
    }



    @Test(description = "Search places in price range (200-230) and verify", groups = "Regression1")
    @Feature("Check Price Ranges in Dasveneba Page")
    @Story("Verify price ranges for places in Dasveneba section")
    @Description("This test verifies that places within the price range 200-230 are displayed.")
    public void verifyPriceRangesInDasveneba() {
        mainSteps.hovering().clickCookie().clickDasveneba();
        relaxSteps.scrollDown().minPrice().maxPrice().clickSearch().checkPrices();
    }

    @Test(description = "Check sold vouchers amount", groups = "Regression1")
    @Feature("Check Sold Vouchers Amount")
    @Story("Verify the number of sold vouchers")
    @Description("This test verifies the number of sold vouchers for sushi deals.")
    public void verifySoldVouchersAmount() {
        categoriesSteps.categoriesSelection().foodHover().clickSushi();
        sushiSteps.firstElement().loginAssert().closingLoginForm().checkingSoldVoucher();
    }

    @Test(description = "Use sorting filter", groups = "Regression2")
    @Feature("Sort Food Prices and Verify")
    @Story("Sort and filter sushi prices")
    @Description("This test verifies that sushi prices are sorted in decreasing order.")
    public void sortAndFilterSushiPrices() {
        categoriesSteps.categoriesSelection().foodHover().clickSushi();
        sushiSteps.clickSorting().decreasing().checkingDecreasingSort();
    }

    @Test(description = "Check share button and popup window", groups = "Regression2")
    @Feature("Check Share Button")
    @Story("Share a first element - sushi on Facebook")
    @Description("This test shares a sushi on Facebook.")
    public void shareSushiDealOnFacebook() {
        categoriesSteps.categoriesSelection().foodHover().clickSushi();
        sushiSteps.clickingSushi();
        mainSushiSteps.shareLink();
    }

    @Test(description = "Fill registration form with data", groups = "Regression2")
    @Feature("Fill Registration Form")
    @Story("Fill and submit a registration form")
    @Description("This test fills a registration form with data, submits it, and validates the information.")
    public void fillRegistrationFormWithData() {
        dataBase.connect();
        try {
            DataBase dataBase = new DataBase().insertData().commitChanges();
            registrationSteps.login().clickRegistration().firstName(dataBase.getFirstName()).lastName(dataBase.getLastName())
                    .inputEmail(dataBase.getEmail()).phoneNumber(dataBase.getPhone()).inputDate(dataBase.getDateOfBirth())
                    .inputPass(dataBase.getPassword()).confirmPassword(dataBase.getPassword())
                    .submit().infoMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod(alwaysRun = true)
    @Description("Close the browser")
    public void tearDown() {
        closeWebDriver();
    }
}
