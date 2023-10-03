package steps;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.RegistrationPage;


import java.sql.Date;


public class RegistrationSteps {

    RegistrationPage registrationPage = new RegistrationPage();

    @Step("Clicking login button")
    public RegistrationSteps login() {
        registrationPage.login.click();
        return this;
    }

    @Step("Clicking registration button")
    public RegistrationSteps clickRegistration() {
        registrationPage.registration.click();
        return this;
    }

    @Step("firstName")
    public RegistrationSteps firstName(String firstName) {
        registrationPage.name.sendKeys(firstName);
        return this;
    }

    @Step("lastName")
    public RegistrationSteps lastName(String lastName) {
        registrationPage.surname.sendKeys(lastName);
        return this;
    }

    @Step("phone number")
    public RegistrationSteps phoneNumber(String phone) {
        registrationPage.phoneNumber.sendKeys(phone);
        return this;
    }

    @Step("email")
    public RegistrationSteps inputEmail(String email) {
        registrationPage.mail.sendKeys(email);
        return this;
    }

    @Step("date of birth")
    public RegistrationSteps inputDate(Date dateOfBirth) {
        registrationPage.date.sendKeys(dateOfBirth.toString());
        return this;
    }

    @Step("password")
    public RegistrationSteps inputPass(String password) {
        registrationPage.password.sendKeys(password);
        return this;
    }

    @Step("confirmation password")
    public RegistrationSteps confirmPassword(String password) {
        registrationPage.confirmPassword.sendKeys(password);
        return this;
    }


    @Step("submit button")
    public RegistrationSteps submit() {
        registrationPage.registrationButton.click();
        return this;
    }

    @Step("Check info message")
    public RegistrationSteps infoMessage() {
        registrationPage.errorMessage.shouldBe(Condition.visible);
        return this;
    }

}