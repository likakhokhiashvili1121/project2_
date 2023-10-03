package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import pages.SushiPage;
import java.util.Objects;

public class SushiSteps {


    SushiPage sushiPage = new SushiPage();
    SoftAssert softAssert = new SoftAssert();

    @Step
    public SushiSteps firstElement() {
        sushiPage.firstFavouriteProduct.click();
        return this;
    }

    @Step
    public SushiSteps loginAssert() {
        sushiPage.loginPage.shouldBe(Condition.visible);
        return this;
    }

    @Step
    public SushiSteps closingLoginForm() {
        sushiPage.closeButton.click();
        return this;
    }

    @Step("Validation of sold Vouchers")
    public SushiSteps checkingSoldVoucher() {
        String soldText = sushiPage.sold.get(0).getText();
        String parseSoldText = soldText.replace("გაყიდულია ", "");
        int value = Integer.parseInt(parseSoldText);

        String diagram = Objects.requireNonNull(sushiPage.soldDiagram.get(0).getAttribute("data-width"))
                .replace("%", "");

        int diagramPercentage = Integer.parseInt(diagram);

        if (value == 0) {
            System.out.println("Nothing is sold");
        } else if (diagramPercentage == 100) {
            System.out.println("All sold out");
            softAssert.fail();
        } else {
            int total = value * 100 / diagramPercentage;
            int currentValue = total * diagramPercentage / 100;
            softAssert.assertEquals(value, currentValue);
        }

        softAssert.assertAll();
        return this;
    }


    @Step("Click sorting")
    public SushiSteps clickSorting() {
        sushiPage.sorting.click();
        return this;
    }

    @Step("Click decreasing")
    public SushiSteps decreasing() {
        sushiPage.klebadiFasi.click();
        return this;
    }

    @Step("Check decreasing sort output")
    public SushiSteps checkingDecreasingSort() {

        String firstSushi = sushiPage.sushiPrices.get(0).getText().replace("₾", "");
        String secondSushi = sushiPage.sushiPrices.get(1).getText().replace("₾", "");

        int firstSushiPrice = Integer.parseInt(firstSushi);
        int secondSushiPrice = Integer.parseInt(secondSushi);

        softAssert.assertEquals(true, firstSushiPrice > secondSushiPrice);
        softAssert.assertAll();
        return this;


    }

    @Step("Click Sushi")
    public SushiSteps clickingSushi() {
        sushiPage.firstProduct.click();
        return this;
    }

}
