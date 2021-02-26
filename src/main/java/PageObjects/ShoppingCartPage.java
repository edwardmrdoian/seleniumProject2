package PageObjects;

import DatabaseObjects.DB_Methods;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ShoppingCartPage {
    SelenideElement proceedToCheckoutButton = $("#center_column  a[title='Proceed to checkout']");
    SelenideElement emailInput = $("#email");
    SelenideElement password = $("#passwd");
    SelenideElement signIn = $("#SubmitLogin");
    SelenideElement proceedToCheckoutAddress = $("button[name='processAddress']");
    SelenideElement termsOfService = $("#cgv");
    SelenideElement proceedToCheckoutTerms = $("button[name='processCarrier']");
    SelenideElement bankWire = $(".bankwire");
    SelenideElement confirmButton = $("#cart_navigation button");
    SelenideElement customerSupport = $x("//a[contains(text(),'expert customer support team. ')]");

    @Step("ProceedToCheckout")
    public ShoppingCartPage ProceedToCheckout(){
        proceedToCheckoutButton.scrollTo().click();
        return this;
    }

    @Step("SignIn")
    public ShoppingCartPage SignIn(){
        emailInput.setValue(DB_Methods.getEmail());
        password.setValue(DB_Methods.getPassword());
        signIn.click();
        return this;
    }

    @Step("SkipAddress")
    public ShoppingCartPage SkipAddress(){
        proceedToCheckoutAddress.scrollTo().click();
        return this;
    }

    @Step("AcceptTermsAndProceed")
    public ShoppingCartPage AcceptTermsAndProceed(){
        termsOfService.click();
        proceedToCheckoutTerms.scrollTo().click();
        return this;
    }

    @Step("PaymentMethod")
    public ShoppingCartPage PaymentMethod(){
        bankWire.click();
        return this;
    }

    @Step("ConfirmOrder")
    public ShoppingCartPage ConfirmOrder(){
        confirmButton.scrollTo().click();
        return this;
    }

    @Step("CustomerService")
    public ShoppingCartPage CustomerService(){
        customerSupport.click();
        return this;
    }
}
