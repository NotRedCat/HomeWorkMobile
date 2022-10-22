package helpers;

import drivers.MobileConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
        return given()
                .filter(new AllureRestAssured())
                .log().all()
                .auth().basic(config.getBrowserstackUser(),config.getBrowserstackKey())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}