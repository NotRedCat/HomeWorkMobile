package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    public static void setup() {
        String host = System.getProperty("deviceHost");
        host ="real";
        if (host.equals("browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else if (host.equals("local")) {
            Configuration.browser = LocalMobileDriver.class.getName();
        } else if (host.equals("real")) {
            Configuration.browser = LocalMobileDriver.class.getName();

        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        open();

    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId().toString();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();
      //  if (System.getProperty("deviceHost").equals("browserstack")) {
       //     Attach.video(sessionId);
        }
    }

