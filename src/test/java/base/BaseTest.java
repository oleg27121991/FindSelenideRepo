package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    void init() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = "118";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 4000;
    }

    @AfterEach
    void addAttachments() {
        Selenide.closeWebDriver();
    }
}

