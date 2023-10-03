package steps;

import io.qameta.allure.Step;
import pages.CategoriesPage;

public class CategoriesSteps {
    CategoriesPage categoriesPage = new CategoriesPage();

    @Step("Categories field")
    public CategoriesSteps categoriesSelection() {
        categoriesPage.categories.click();
        return this;
    }

    @Step("Clicking food")
    public CategoriesSteps foodHover() {
        categoriesPage.food.hover();
        return this;
    }

    @Step("Clicking Sushi")
    public CategoriesSteps clickSushi() {
        categoriesPage.sushi.click();
        return this;
    }
}
