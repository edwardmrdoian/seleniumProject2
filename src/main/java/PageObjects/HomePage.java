package PageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    SelenideElement signIn = $(".login");
    SelenideElement bestSellers = $("a.blockbestsellers");
    SelenideElement dresses = $("#block_top_menu > ul > li > a[title='Dresses']");
    SelenideElement eveningDresses = $("#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(2) > a");


    @Step("SignIn")
    public HomePage SignIn(){
        signIn.click();
        return this;
    }

    @Step("MoveToBestSellers")
    public HomePage MoveToBestSellers(){
        bestSellers.scrollTo().click();
        return this;
    }

    @Step("MoveToEveningDresses")
    public HomePage MoveToEveningDresses(){
        dresses.hover();
        eveningDresses.click();
        return this;
    }

}
