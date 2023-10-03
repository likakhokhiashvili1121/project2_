package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SushiSharePage {

    ////*[@id="partialid"]/section/div[1]/div[1]/a/img
    //public SelenideElement firstSushi  = $(byXpath("//section[@class='container deal-container category-offers ']"));
    public SelenideElement shareButton = $(".share");
    public SelenideElement facebookLoginForm = $("#loginform");
}

