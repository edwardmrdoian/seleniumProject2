package PageObjects;

import DataObjects.InsertData;
import DatabaseObjects.DB_Methods;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class SignUpPage  {
    InsertData insertData = new InsertData();

    public static SelenideElement email = $x("//*[@id='email_create']");
    public static SelenideElement createAccount = $x("//input[@name='email_create']/following::button[1]");
    public static SelenideElement firstName = $x("//label[@for='customer_firstname']/following-sibling::input");
    public static SelenideElement lastName = $x("//*[@id='customer_lastname']");
    public static SelenideElement password = $x("//*[@id='passwd']");
    public static SelenideElement personalAddress = $("#address1");
    public static SelenideElement firstName2 = $("#firstname");
    public static SelenideElement lastName2 = $("#lastname");
    public static SelenideElement city = $("#city");
    public static SelenideElement state = $("#id_state");
    public static SelenideElement zipCode = $("#postcode");
    public static SelenideElement mobilePhone = $("#phone_mobile");
    public static SelenideElement register = $x("//*[@id='submitAccount']/span");

    @Step("InsertUserToDatabase")
    public SignUpPage InsertUserToDatabase(){
        DB_Methods.InsertUsers(insertData.getName(), insertData.getSurname(), insertData.getEmail(), insertData.getPasswd(), insertData.getPhone(), insertData.getAddress(), insertData.getCity(), insertData.getState(), insertData.getZip());
        return this;
    }

    @Step("SelectUser")
    public SignUpPage SelectUser(){
        DB_Methods.SelectLastUser();
        return this;
    }

    @Step("CreateNewAccount")
    public SignUpPage CreateNewAccount(){
        email.setValue(DB_Methods.getEmail());
        createAccount.click();
        return this;
    }

    @Step("FillSignUp")
    public SignUpPage FillSignUp(){
        firstName.setValue(DB_Methods.getName());
        lastName.setValue(DB_Methods.getLastname());
        firstName2.setValue(DB_Methods.getName());
        lastName2.setValue(DB_Methods.getLastname());
        password.setValue(DB_Methods.getPassword());
        personalAddress.setValue(DB_Methods.getAddress());
        city.setValue(DB_Methods.getCity());
        zipCode.setValue(String.valueOf(DB_Methods.getZip()));
        mobilePhone.setValue(DB_Methods.getPhone());
        state.selectOption(DB_Methods.getState());
        return this;
    }

    @Step("Register")
    public void Register(){
        register.click();
    }
}
