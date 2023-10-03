package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.RestPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RestSteps {
    RestPage relaxPage = new RestPage();
    SoftAssert softAssert = new SoftAssert();

    @Step("Scroll down")
    public RestSteps scrollDown() {
        relaxPage.priceField.scrollIntoView(true);
        return this;
    }

    @Step("min price")
    public RestSteps minPrice() {
        relaxPage.minPrice.sendKeys("200");
        return this;
    }

    @Step("max price")
    public RestSteps maxPrice() {
        relaxPage.maxPrice.sendKeys("230");
        return this;
    }

    @Step("Clicking search button for prices")
    public RestSteps clickSearch() {
        relaxPage.search.click();
        return this;
    }

    @Step("Check price range")
    public RestSteps checkPrices() {
        webdriver().shouldHave(url("https://www.swoop.ge/category/24/dasveneba/?minprice=200&maxprice=230"));
        for (WebElement priceElement : relaxPage.prices) {
            String actualString = priceElement.getText();
            String editedString = actualString.replace("₾", "");
            int valueOfString = Integer.parseInt(editedString);
            softAssert.assertTrue(valueOfString >= 200 && valueOfString <= 230);
        }
        softAssert.assertAll();
        return this;
    }

}
