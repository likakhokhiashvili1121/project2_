/*
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
import steps.RegistrationSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Test5 {
    WebDriver driver;
    DataBase dataBase = new DataBase();
    RegistrationSteps registrationSteps = new RegistrationSteps();
    DBconnection dBconnection = new DBconnection();
    @BeforeMethod(alwaysRun = true)

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        open("https://www.swoop.ge/");

    }

    public void FifthTest() {
        dataBase.connection();
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
    public void tearDown() {
        closeWebDriver();
    }

}

 */
