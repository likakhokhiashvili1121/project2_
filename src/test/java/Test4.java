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
import steps.CategoriesSteps;
import steps.SushiShareSteps;
import steps.SushiSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Test4 {

    CategoriesSteps categoriesSteps = new CategoriesSteps();
    SushiSteps sushiSteps = new SushiSteps();
    SushiShareSteps mainSushiSteps = new SushiShareSteps();
    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        open("https://www.swoop.ge/");

    }
    public void ForthTest() {
        categoriesSteps.categoriesSelection().foodHover().clickSushi();
        sushiSteps.clickingSushi();
        mainSushiSteps.shareLink();


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }


}


 */