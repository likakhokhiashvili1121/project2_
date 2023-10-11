package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SushiPage {
    public SelenideElement firstProduct = $$(byXpath("//section[@class='container deal-container category-offers ']")).first();
    public SelenideElement firstFavouriteProduct = firstProduct.$(byClassName("deal-box-wishlist"));
    public SelenideElement loginPage = $(".login");
    public SelenideElement closeButton = $("div[class='close-button'] a");

    public SelenideElement sorting = $("#sort");
    public SelenideElement klebadiFasi = $(byXpath("//option[contains(text(),'ფასით კლებადი')]"));
    public List<SelenideElement> soldDiagram = $$(By.xpath("//div[@class = 'voucher-diagram']//div"));
    public List<SelenideElement> sushiPrices = $$("div.discounted-prices p:first-child");
    public List<SelenideElement> sold = $$(By.xpath("//p[contains(text(), 'გაყიდულია')]"));

}
