package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement cookie = $(By.className("cookieSection"));
    public SelenideElement acceptCookie = $(".acceptCookie");
    public SelenideElement davsvenebaLink = Selenide.$(By.linkText("დასვენება"));

}
