package PageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class EveningDressesPage {
    SelenideElement printedDress = $x("//div[@class='left-block']//img[contains(@title,'Printed')]");
    SelenideElement addToCart = $("a[title='Add to cart']");

    @Step("ChooseDress")
    public EveningDressesPage ChooseDress(){
        printedDress.hover();
        return this;
    }

    @Step("AddToCart")
    public EveningDressesPage AddToCart(){
        addToCart.click();
        return this;
    }

}
