package tests.local;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class LocalTests extends TestBase {

    @Test
    void searchTest() {
        step("Click skip", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).first().click());
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
    @Test
    void searchDisneylandTest() {
        step("Click skip", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).first().click());
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Disneyland");
        });

        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

        /*$$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).find(Condition.text("Disneyland")).click();
        $$(AppiumBy.id("org.wikipedia.alpha:id/pcs-edit-section-title-description"))
                .find(Condition.text("Disneyland"));*/
    }
    @Test
    void gettingStartedTest() {
        open();
        step("First screen", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(CollectionCondition.texts("The Free Encyclopedia …in over 300 languages")));
        step("Click continue", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).first().click());
        step("Second screen", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(CollectionCondition.texts("New ways to explore")));
        step("Click continue", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).first().click());
        step("Third screen", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(CollectionCondition.texts("Reading lists with sync")));
        step("Click continue", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).first().click());
        step("Last screen", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(CollectionCondition.texts("Send anonymous data")));
        step("Click switch", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/switchView")).first().click());
        step("Click continue", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).first().click());
        step("Search search", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).shouldBe(Condition.visible));
    }
}