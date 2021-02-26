package Listeners;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;


public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        try {
            screenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // SaveTextLogs(result.getMethod().getConstructorOrMethod().getName() + " failed and screenshot taken");
    }
    @Attachment(value = "Screenshot",type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
    //@Attachment(value = "Stacktrace", type = "text/plain")
    //public static String SaveTextLogs(String message) {
    //    return message;
    //}
}
