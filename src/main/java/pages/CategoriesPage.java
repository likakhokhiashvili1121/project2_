package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CategoriesPage {

    public SelenideElement categories = $(".categoriesTitle");
    public SelenideElement food = Selenide.$(By.linkText("კვება"));
    public SelenideElement sushi = Selenide.$(By.linkText("სუში"));

}
