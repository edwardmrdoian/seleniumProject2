package PageObjects;

import com.codeborne.selenide.SelenideElement;
import java.io.File;
import static com.codeborne.selenide.Selenide.*;
import DataObjects.CustomerServicePageData;
import io.qameta.allure.Step;

public class CustomerServicePage {
    SelenideElement heading =$("#id_contact");
    SelenideElement orderReference = $("[name='id_order']");
    SelenideElement fileUpload = $("#fileUpload");
    SelenideElement textArea = $("#message");
    SelenideElement submitMessage = $("#submitMessage");
    CustomerServicePageData customer = new CustomerServicePageData();

    @Step("SelectHeading")
    public CustomerServicePage SelectHeading(){
        heading.selectOption("Customer service");
        return this;
    }

    @Step("SelectOrderReference")
    public CustomerServicePage SelectOrderReference(){
        orderReference.selectOption(1);
        return this;
    }

    @Step("UploadFile")
    public CustomerServicePage UploadFile(){
        fileUpload.uploadFile(getFilePathByFormat(customer.getFilePath()));
        return this;
    }

    @Step("Message")
    public CustomerServicePage Message(){
        textArea.setValue(customer.getMessage());
        return this;
    }

    @Step("Send")
    public CustomerServicePage Send(){
        submitMessage.click();
        return this;
    }

    private File getFilePathByFormat(String filePath) {
        return new File(filePath);
    }
}
