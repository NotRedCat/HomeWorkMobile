package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;


public class AndroidSearchTests extends TestBase {

    @Test
    void searchTest() {
        step("Поиск статьи про Disneyland", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Disneyland");
        });
        step("Проверка, что хотя бы одна статья есть", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        step("Переход к первой статье", () ->
        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click());
        step("Проверка, что тест есть на странице", () ->
        $(AppiumBy.accessibilityId("Amusement park in Anaheim, California")));

    }
}