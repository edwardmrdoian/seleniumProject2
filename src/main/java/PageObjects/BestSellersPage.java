package PageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class BestSellersPage {
    SelenideElement chiffonDress = $x("//*[@id='blockbestsellers']/li//img[contains(@title,'Chiffon')]");
    SelenideElement more = $x("//ul[@id='blockbestsellers']//a[@title='View']");
    SelenideElement title = $("title");

    @Step("ChooseProduct")
    public BestSellersPage ChooseProduct(){
        chiffonDress.hover();
        return this;
    }

    @Step("ClickMore")
    public BestSellersPage ClickMore(){
        more.click();
        return this;
    }

    @Step("ValidateTitle")
    public BestSellersPage ValidateTitle(){
        title.shouldHave(attribute("text", "Printed Chiffon Dress - My Store"));
        return this;
    }

}
