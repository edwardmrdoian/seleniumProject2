import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import CustomAnnotation.RetryCountIfFailed;
import Listeners.*;
import PageObjects.*;
import io.qameta.allure.*;
import org.testng.annotations.*;


@Listeners(TestListener.class)
public class Project2Test {
    public Project2Test() {
        timeout = 10000;
        startMaximized = true;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        open("http://automationpractice.com/index.php");
    }


    @Description("User Sign Up")
    @Epic("Project2Test")
    @Feature("Feature1: SignUp Page")
    @Story("Story: Create new Account")
    @Severity(SeverityLevel.CRITICAL)
    @Test(alwaysRun = true,description = "User Sign Up",testName = "Registration")
    public void UserRegistration(){
        HomePage homePage = new HomePage();
        //Move to 'Sign In'
        homePage.SignIn();
        //User Registration
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.InsertUserToDatabase().SelectUser().CreateNewAccount()
                .FillSignUp()
                .Register();
    }
    @DataProvider(name="SendToFriend")
    public Object[][] getDataFromDataProvider(){
        return new Object[][] {
                { "John", "JohnDoe23@gmail.com" },
                { "Bella", "BellaStuart98@gmail.com"}
        };
    }

    @Description("Send Dress To Friend")
    @Epic("Project2Test")
    @Feature("Feature2: BestSellers Page")
    @Story("Story: Select Product For Friend")
    @Test(dataProvider ="SendToFriend" ,priority = 1,groups = {"Resgression1"},description = "Send Dress To Friend",testName = "Friends")
    public void SecondTest(String name,String email){
        HomePage homePage = new HomePage();
        //Move to the 'Best Sellers
        homePage.MoveToBestSellers();
        //Choose product that has a discount and click more button than validate page change
        BestSellersPage bestSellersPage = new BestSellersPage();
        bestSellersPage.ChooseProduct().ClickMore().ValidateTitle();
        //Send dress to Friend
        SendToFriendPage sendToFriendPage = new SendToFriendPage();
        sendToFriendPage.SendToFriend(name,email);

    }

    @Description("User Sign In and Buy Dress")
    @Epic("Project2Test")
    @Feature("Feature3: BestSellers Page And Checkout")
    @Story("Story: Buy BestSeller Dress")
    @Test(dependsOnMethods = {"UserRegistration"} ,priority = 2,groups = {"Resgression2"},description = "User Sign In and Buy Dress",testName = "Buy Dress One")
    public void ThirdTest(){
        HomePage homePage = new HomePage();
        //Move to the 'Best Sellers
        homePage.MoveToBestSellers();
        //Choose product that has a discount and click more button than validate page change
        BestSellersPage bestSellersPage = new BestSellersPage();
        bestSellersPage.ChooseProduct().ClickMore().ValidateTitle();
        //Add item to the Cart
        BestSellerDressPage bestSellerDressPage = new BestSellerDressPage();
        bestSellerDressPage.AddItemToCart();
        //ProceedToCheckout
        AlertPage alertPage = new AlertPage();
        alertPage.ProceedToCheckout();
        //Sign in and Confirm Order
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.ProceedToCheckout().SignIn().SkipAddress()
                .AcceptTermsAndProceed().PaymentMethod().ConfirmOrder();
    }

    @Description("User Sign In and Buy Dress")
    @Epic("Project2Test")
    @Feature("Feature4:  EveningDresses Page And Checkout")
    @Story("Story: Buy EveningDress Dress ")
    @RetryCountIfFailed(3)
    @Test(dependsOnMethods = {"UserRegistration"} ,priority = 3,groups = {"Resgression2"},description = "User Sign In and Buy Dress" ,testName = "Buy Dress Two")
    public void FourthTest(){
        //Go to Evening Dresses
        HomePage homePage = new HomePage();
        homePage.MoveToEveningDresses();
        //Choose Printed Dress
        EveningDressesPage eveningDressesPage = new EveningDressesPage();
        eveningDressesPage.ChooseDress().AddToCart();
        //ProceedToCheckout
        AlertPage alertPage = new AlertPage();
        alertPage.ProceedToCheckout();
        //Sign in and Confirm Order
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.ProceedToCheckout().SignIn().SkipAddress()
                .AcceptTermsAndProceed().PaymentMethod().ConfirmOrder().CustomerService();
        //Choose heading and order reference, upload file, add message text and Send
        CustomerServicePage customerServicePage = new CustomerServicePage();
        customerServicePage.SelectHeading().SelectOrderReference().UploadFile()
                .Message().Send();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
