package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {
    MainPage mainPage = new MainPage();

    @Step("Hover cookie")
    public MainSteps hovering() {
        mainPage.cookie.hover();
        return this;
    }

    @Step("Clicking cookie")
    public MainSteps clickCookie() {
        mainPage.acceptCookie.click();
        return this;
    }

    @Step("Clicking დასვენება")
    public MainSteps clickDasveneba() {
        mainPage.davsvenebaLink.click();
        return this;
    }
}
