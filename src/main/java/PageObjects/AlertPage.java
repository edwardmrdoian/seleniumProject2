package PageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class AlertPage {
    SelenideElement ProceedToCheckoutButton = $x("//a[starts-with(@title,'Proceed')]");

    @Step("ProceedToCheckout")
    public AlertPage ProceedToCheckout(){
        ProceedToCheckoutButton.scrollTo().click();
        return this;
    }
}
