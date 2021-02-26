package DataObjects;

import org.apache.commons.lang3.RandomStringUtils;

public class CustomerServicePageData {
    String message =  RandomStringUtils.randomAlphabetic(150);
    String filePath = "src/main/java/Files/FileForCustomerService.txt";

    public String getMessage() {
        return message;
    }

    public String getFilePath() {
        return filePath;
    }
}
