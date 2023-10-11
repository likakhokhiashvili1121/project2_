/*
- Create 1st test method
- Open the chrome browser
- Navigate to the swoop.ge
- Go to „დასვენება“
- In &#39;ფასი&#39; element put range from 200 to 230
- Check that all returned elements on the first page are in selected range
 */

/*
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.MainSteps;
import steps.RestSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Test1 {

     WebDriver driver;

     MainSteps mainSteps = new MainSteps();
     RestSteps relaxSteps = new RestSteps();



    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        open("https://www.swoop.ge/");

    }

    @Test
    public void FirstTest() {
        mainSteps.hovering().clickCookie().clickDasveneba();
        relaxSteps.scrollDown().minPrice().maxPrice().clickSearch().checkPrices();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }


}


 */