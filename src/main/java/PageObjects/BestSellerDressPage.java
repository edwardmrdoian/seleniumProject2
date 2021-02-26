package PageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class BestSellerDressPage {
    SelenideElement sendToFriend = $("#send_friend_button");
    SelenideElement popUp = $(".sendtofriend div div");
    SelenideElement sizeDropDown = $x("//select[@name='group_1']");
    SelenideElement quantityPlusButton = $x("//a[contains(@class,'plus')]");
    SelenideElement addItemToCart = $("#add_to_cart > button");

    @Step("OpenSendPopUp")
    public BestSellerDressPage OpenSendPopUp(){
        sendToFriend.click();
        return this;
    }

    @Step("ValidatePopUp")
    public BestSellerDressPage ValidatePopUp(){
        popUp.shouldHave(attribute("class", "fancybox-placeholder"));
        return this;
    }

    @Step("AddItemToCart")
    public BestSellerDressPage AddItemToCart(){
        sizeDropDown.selectOption("M");
        for (int i=0;i<2;i++){
            quantityPlusButton.click();
        }
        addItemToCart.click();
        return this;
    }
}
