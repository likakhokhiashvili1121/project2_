package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.SushiSharePage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;

public class SushiShareSteps {
    SushiSharePage mainSushiPage = new SushiSharePage();

/*
    @Step("click on first sushi")
    public MainSushiSteps firstsushi(){
        mainSushiPage.firstSushi.click();
        return this;
    }

 */


    @Step("Click share and check facebook login form")
    public SushiShareSteps shareLink() {
        mainSushiPage.shareButton.click();
        switchTo().window("Facebook");
        mainSushiPage.facebookLoginForm.shouldBe(Condition.visible);
        closeWindow();
        return this;
    }


}