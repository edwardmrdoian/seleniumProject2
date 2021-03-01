package PageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class SendToFriendPage {
    SelenideElement nameInput = $("#friend_name");
    SelenideElement emailInput = $("#friend_email");
    SelenideElement sendMail = $("#sendEmail");
    SelenideElement okButton = $(".submit input");

    @Step("SendToFriend")
    public SendToFriendPage SendToFriend(String name,String email){
        BestSellerDressPage bestSellerDressPage = new BestSellerDressPage();
        bestSellerDressPage.OpenSendPopUp().ValidatePopUp();
        nameInput.setValue(name);
        emailInput.setValue(email);
        sendMail.click();
        okButton.click();
        return this;
    }
}
